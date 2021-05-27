package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    val searchMovieLiveData = MutableLiveData<MoviesResponseTMDB>()
    var prepareListMovie = ArrayList<MovieTMDB>()
    private var currentSearchTitle: String = ""
    private var currentPage: Int = 1

    fun fetchData(searchTitle: String) {
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
                    prepareListMovie.addAll(value.results!!)
                }
            })
    }
}