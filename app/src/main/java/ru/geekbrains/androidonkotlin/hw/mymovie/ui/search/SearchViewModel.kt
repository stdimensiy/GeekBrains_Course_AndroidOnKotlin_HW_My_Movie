package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModel : ViewModel() {
    private val repository: TestMoviesRepository = TestMoviesRepository()
    val searchMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()

    fun fetchData() {
        // вместо поисковой фразы пока пустая строка
        repository.getNowPlayingMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                searchMovieLiveData.postValue(value)
            }
        })
    }
}