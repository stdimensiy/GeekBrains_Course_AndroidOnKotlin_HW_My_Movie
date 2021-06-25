package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.room.SearchHistory

class SearchViewModel(
    app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    val searchMovieLiveData = MutableLiveData<MoviesResponseTmdb>()
    var prepareListMovie = ArrayList<MovieTmdb>()
    private val preferenceManager = PreferenceManager.getDefaultSharedPreferences(app)
    private var tmdbApiKeyV3: String = preferenceManager.getString("tmdbApiKeyV3", "").toString()
    private var adultAdded = !preferenceManager.getBoolean("adultAdded", true)
    private var excludeMoviesWithoutPoster =
        preferenceManager.getBoolean("excludeMoviesWithoutPoster", true)
    private var excludeMoviesWithoutReleaseData =
        preferenceManager.getBoolean("excludeMoviesWithoutReleaseData", true)

    private var currentSearchTitle: String = ""
    private var currentPage: Int = 1

    fun fetchData(searchTitle: String) {
        if (searchTitle != currentSearchTitle) {
            this.currentSearchTitle = searchTitle
            currentPage = 1
            repository.saveEntity(searchTitle)
        } else {
            currentPage++
        }
        repository.getDiscoveredMovies(
            currentSearchTitle,
            tmdbApiKeyV3,
            adultAdded,
            currentPage,
            object : CallBack<MoviesResponseTmdb> {
                override fun onResult(value: MoviesResponseTmdb) {
                    searchMovieLiveData.postValue(value)
                    //часть условий которые можно обработать только на стороне клиента
                    //API сервиса не предоставляют возможности в запросе отсеять некорректные данные
                    value.results.forEach {
                        if ((excludeMoviesWithoutPoster && it.posterPath.isNullOrBlank()) ||
                            (excludeMoviesWithoutReleaseData && it.releaseDate.isNullOrBlank())
                        ) {
                            //элемент исключается из обработанной коллекции но сохраняется в результатах выборки
                        } else {
                            prepareListMovie.add(it)
                        }
                    }
                }
            })
        repository.getAllHistorySearch(object : CallBack<List<SearchHistory>>{
            override fun onResult(value: List<SearchHistory>) {
                value.forEach {
                    Log.d("Моя проверка", it.searchQuery)
                }
            }
        })
    }
}