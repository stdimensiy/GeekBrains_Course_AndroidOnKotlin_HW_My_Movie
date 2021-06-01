package ru.geekbrains.androidonkotlin.hw.mymovie.ui.about

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class AboutViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = app.getString(R.string.default_test_string_line_for_about)
    }

    //ЗАГЛУШКА временно
    val text: LiveData<String> = _text
}