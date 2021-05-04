package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoreDetailedViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Этoт фрагмент \n сообщает детальную информацию о фильме. \n" +
                "реализовать добавление собственного рейтинга и комментария, может еще что..."
    }
    val text: LiveData<String> = _text
}