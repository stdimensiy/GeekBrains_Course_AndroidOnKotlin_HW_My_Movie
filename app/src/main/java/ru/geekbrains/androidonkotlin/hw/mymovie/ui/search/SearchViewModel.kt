package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    val searchMovieLiveData = MutableLiveData<MoviesResponseTmdb>()
    var prepareListMovie = ArrayList<MovieTmdb>()
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
            object : CallBack<MoviesResponseTmdb> {
                override fun onResult(value: MoviesResponseTmdb) {
                    searchMovieLiveData.postValue(value)
                    prepareListMovie.addAll(value.results)
                }
            })
    }
}