package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.app.Application
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class ContactsListViewModel(
    app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    fun fetchData() {

    }

}