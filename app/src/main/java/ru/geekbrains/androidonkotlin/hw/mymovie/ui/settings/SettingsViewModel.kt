package ru.geekbrains.androidonkotlin.hw.mymovie.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Этo фрагмент \n настроек программы. \n" +
                "реализовать дневной и ночной режим, количество рубрик в левом меню и содержимое главного фрагмента."
    }
    val text: LiveData<String> = _text
}