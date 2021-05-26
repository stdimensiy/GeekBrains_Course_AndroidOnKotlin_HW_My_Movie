package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class MoreDetailedViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    //временне для старта, в дальнейшем через этот фрагмент будет осуществляться взаимодействие с базой
    //в части обновления детальных данных по фильму
    //загрузке детальных данны
    //обработке добавления фильма в список избранного или собственную подборку
    //может еще что придумаю
    private val _text = MutableLiveData<String>().apply {
        value = "Этoт фрагмент \n сообщает детальную информацию о фильме. \n" +
                "реализовать добавление собственного рейтинга и комментария, может еще что..."
    }
    val text: LiveData<String> = _text
}