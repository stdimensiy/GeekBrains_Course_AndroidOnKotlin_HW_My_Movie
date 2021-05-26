package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class HomeViewModel : ViewModel() {

    private val repository: TestMoviesRepository = TestMoviesRepository()
    val homeBasicStructureLiveData = MutableLiveData<ArrayList<ListMovies>>()
    val popularMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val upcomingMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val topRatedMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val nowPlayingMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()

    fun fetchData() {
        //подготовка данных
        //состав подборок домашнего фрагмента
        repository.getHomeFragmentStructure(object : CallBack<ArrayList<ListMovies>> {
            override fun onResult(value: ArrayList<ListMovies>) {
                homeBasicStructureLiveData.postValue(value)
            }
        })
        //принудительно инициируем заполнение данных
        fetchPopularData()
        fetchUpcomingData()
        fetchNowPlayingData()
        fetchTopRatedData()
        // по иде на данном этапе все лайвдаты должны так или иначе содержать данные, хотя при асинхронном запросе не факт...
    }

    //временно пока не найду способа объединить запросы
    //подборка "популярные видео"
    fun fetchPopularData() {
        repository.getPopularMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                popularMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Ожидаемые видео"
    fun fetchUpcomingData() {
        repository.getUpcomingMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                upcomingMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Смотрят сейчас"
    fun fetchNowPlayingData() {
        repository.getNowPlayingMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                nowPlayingMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Лучшие"
    fun fetchTopRatedData() {
        repository.getTopRatedMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                topRatedMovieLiveData.postValue(value)
            }
        })
    }
}