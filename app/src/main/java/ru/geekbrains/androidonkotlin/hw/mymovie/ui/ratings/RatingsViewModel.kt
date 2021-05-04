package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RatingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = " Это модуль предоставления актуальных рейтингов.\n" +
                " Представление ведется в несколько линеейк с горизонтальной прокуткой,\n" +
                " разделение ведется по жантрам,\n" +
                " Должна быть отдельно реализована возможность сортировки по свобственному рейтингу. \n" +
                " должна быть реализована функция добавления фильма в избранное, \n" +
                " присвоение собственного рейтинга и комментария"
    }
    val text: LiveData<String> = _text
}