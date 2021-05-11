package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModel : ViewModel() {
    private val repository: TestMoviesRepository = TestMoviesRepository()
    val searchMovieLiveData = MutableLiveData<ArrayList<String>>()

    fun fetchData() {
        // вместо поисковой фразы пока пустая строка
        repository.getSearchList("", object : CallBack<ArrayList<String>> {
            override fun onResult(value: ArrayList<String>) {
                searchMovieLiveData.postValue(value)
            }
        })
    }
}