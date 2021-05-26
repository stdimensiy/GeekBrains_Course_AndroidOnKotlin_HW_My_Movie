package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class FavoritesViewModel : ViewModel() {
    private val repository: TestMoviesRepository = TestMoviesRepository()
    val favoritesMovieLiveData = MutableLiveData<ArrayList<String>>()

    fun fetchData() {
        repository.getFavoriteList(object : CallBack<ArrayList<String>> {
            override fun onResult(value: ArrayList<String>) {
                favoritesMovieLiveData.postValue(value)
            }
        })
    }
}