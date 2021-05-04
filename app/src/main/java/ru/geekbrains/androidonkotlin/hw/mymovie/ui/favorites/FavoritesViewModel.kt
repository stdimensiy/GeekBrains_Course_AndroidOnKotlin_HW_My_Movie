package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = " Это модуль избранных пользователем фильмов.\n" +
                " функционально должен быть выполнен recyclerview с вертикальной проктукой.\n" +
                " Реализована функция удаления фильма из избранного,\n" +
                " функция добавления собственного комментария и рейтинга. \n" +
                " добавление в избранное производится из других фрагментов \n" +
                "(главного, рейтонгов и результатов поиска)"
    }
    val text: LiveData<String> = _text
}