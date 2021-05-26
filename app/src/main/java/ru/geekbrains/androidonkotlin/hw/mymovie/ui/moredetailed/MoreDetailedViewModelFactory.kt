package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class MoreDetailedViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MoreDetailedViewModel(application, TestMoviesRepository()) as T
}