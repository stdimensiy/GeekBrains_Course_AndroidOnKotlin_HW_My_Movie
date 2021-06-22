package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search.history

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class HistorySearchViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        HistorySearchViewModel(application, TestMoviesRepository()) as T
}