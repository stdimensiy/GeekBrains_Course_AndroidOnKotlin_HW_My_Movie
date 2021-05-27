package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class SearchViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        SearchViewModel(application, TestMoviesRepository()) as T
}