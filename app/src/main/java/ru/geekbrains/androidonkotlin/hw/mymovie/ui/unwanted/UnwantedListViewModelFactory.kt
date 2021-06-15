package ru.geekbrains.androidonkotlin.hw.mymovie.ui.unwanted

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class UnwantedListViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        UnwantedListViewModel(application, TestMoviesRepository()) as T
}