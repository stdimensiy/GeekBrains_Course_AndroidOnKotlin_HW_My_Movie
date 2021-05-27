package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class RatingsViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        RatingsViewModel(application, TestMoviesRepository()) as T
}