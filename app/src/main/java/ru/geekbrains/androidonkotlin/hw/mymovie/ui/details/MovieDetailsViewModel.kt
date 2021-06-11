package ru.geekbrains.androidonkotlin.hw.mymovie.ui.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class MovieDetailsViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    //временне для старта, в дальнейшем через этот фрагмент будет осуществляться взаимодействие с базой
    //в части обновления детальных данных по фильму
    //загрузке детальных данны
    //обработке добавления фильма в список избранного или собственную подборку
    //может еще что придумаю
    private val _text = MutableLiveData<String>().apply {
        value = app.getString(R.string.default_test_string_line_for_more_detailed)
    }
    val text: LiveData<String> = _text
}