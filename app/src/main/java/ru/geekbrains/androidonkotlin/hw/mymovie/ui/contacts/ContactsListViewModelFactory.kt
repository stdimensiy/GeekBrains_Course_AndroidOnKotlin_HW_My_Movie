package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class ContactsListViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ContactsListViewModel(application, TestMoviesRepository()) as T
}