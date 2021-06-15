package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack

class MarkedAaaListViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    val favoritesMovieLiveData = MutableLiveData<List<MovieTmdb>>()
    val prepareListMovies: ArrayList<MovieTmdb> = arrayListOf()
    var lastAnswer: MoviesResponseTmdb = MoviesResponseTmdb()
    private var currentPage: Int = 1

    fun fetchData() {
        val standardList = "top_rated" // временно рубрика выборки (пока не реализована авторизация)
        repository.getStandardsList(
            standardList,
            currentPage,
            object : CallBack<MoviesResponseTmdb> {
                override fun onResult(value: MoviesResponseTmdb) {
                    //получая новую порцию данных обрабатываем её дополнительно по критериям пригодности к отображению
                    // критерии будут определены позже, поэтому сейчас список добавляется к текущему
                    // защита от дублирующих данных
                    if (lastAnswer.page < value.page) {
                        // запись и обработка пришедших данных осуществляется только тогда,
                        // когда номерр страницы нового ответа больше чем предыдущего.
                        lastAnswer = value
                        prepareListMovies.addAll(value.results)
                        favoritesMovieLiveData.postValue(prepareListMovies)
                        currentPage++
                    }
                }
            })
    }
}