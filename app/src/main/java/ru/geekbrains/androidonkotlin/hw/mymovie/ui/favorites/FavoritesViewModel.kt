package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class FavoritesViewModel : ViewModel() {
    private val repository: TestMoviesRepository = TestMoviesRepository()
    val favoritesMovieLiveData = MutableLiveData<MutableList<TestMovie>>()

    fun fetchData() {
        repository.getFavoriteList(object : CallBack<MutableList<TestMovie>> {
            override fun onResult(value: MutableList<TestMovie>) {
                favoritesMovieLiveData.postValue(value)
            }
        })
    }
}