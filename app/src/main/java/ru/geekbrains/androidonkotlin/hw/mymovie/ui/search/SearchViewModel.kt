package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Этoт фрагмент \n осущесвляет отображение результатов поиска фильмов. \n" +
                "реализовать добавление собственного рейтинга, добавления в избранное и комментария, может еще что..."
    }
    val text: LiveData<String> = _text
}