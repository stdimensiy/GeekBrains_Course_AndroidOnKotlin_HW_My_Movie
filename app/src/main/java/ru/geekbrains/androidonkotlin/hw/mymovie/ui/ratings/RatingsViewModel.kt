package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class RatingsViewModel : ViewModel() {

    private val repository: TestMoviesRepository = TestMoviesRepository()
    val ratingBasicStructureLiveData = MutableLiveData<ArrayList<ListMovies>>()
    val popularMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val upcomingMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val topRatedMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
    val nowPlayingMovieLiveData = MutableLiveData<ArrayList<MovieTMDB>>()

    fun fetchData() {
        repository.getRatingFragmentStructure(object : CallBack<ArrayList<ListMovies>> {
            override fun onResult(value: ArrayList<ListMovies>) {
                ratingBasicStructureLiveData.postValue(value)
            }
        })
        //принудительно инициируем заполнение данных
        fetchPopularData()
        fetchUpcomingData()
        fetchNowPlayingData()
        fetchTopRatedData()
    }

    //временно пока не найду способа объединить запросы
    //подборка "популярные видео"
    fun fetchPopularData() {
        // вместо поисковой фразы пока пустая строка
        repository.getPopularMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                popularMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Ожидаемые видео"
    fun fetchUpcomingData() {
        // вместо поисковой фразы пока пустая строка
        repository.getUpcomingMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                upcomingMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Смотрят сейчас"
    fun fetchNowPlayingData() {
        // вместо поисковой фразы пока пустая строка
        repository.getNowPlayingMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                nowPlayingMovieLiveData.postValue(value)
            }
        })
    }

    //подборка "Лучшие"
    fun fetchTopRatedData() {
        // вместо поисковой фразы пока пустая строка
        repository.getTopRatedMovies(object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                topRatedMovieLiveData.postValue(value)
            }
        })
    }
}