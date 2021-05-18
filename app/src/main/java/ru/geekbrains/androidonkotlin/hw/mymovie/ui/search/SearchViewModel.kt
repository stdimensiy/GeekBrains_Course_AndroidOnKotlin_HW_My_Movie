package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModel : ViewModel() {
    private val repository: TestMoviesRepository = TestMoviesRepository()
    val searchMovieLiveData = MutableLiveData<MoviesResponseTMDB>()
    private var currentSearchTitle: String = ""
    private var currentPage: Int = 1

    fun fetchData(searchTitle: String) {
        // вместо поисковой фразы пока запрос списка фильмов которые сейчас в показе
        if (searchTitle != currentSearchTitle) {
            this.currentSearchTitle = searchTitle
            currentPage = 1
        } else {
            currentPage++
        }
        repository.getDiscoveredMovies(
            currentSearchTitle,
            currentPage,
            object : CallBack<MoviesResponseTMDB> {
                override fun onResult(value: MoviesResponseTMDB) {
                    searchMovieLiveData.postValue(value)
                }
            })
    }
}