package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search.history

import android.app.Application
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class HistorySearchViewModel(
    app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {


}