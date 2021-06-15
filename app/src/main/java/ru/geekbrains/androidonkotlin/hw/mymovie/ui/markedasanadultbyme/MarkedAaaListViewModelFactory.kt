package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class MarkedAaaListViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MarkedAaaListViewModel(application, TestMoviesRepository()) as T
}