package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository

class HomeViewModel : ViewModel() {

    private val repository: TestMoviesRepository = TestMoviesRepository()
    val homeBasicStructureLiveData = MutableLiveData<ArrayList<ListMovies>>()

    fun fetchData() {
        repository.getHomeFragmentStructure(object : CallBack<ArrayList<ListMovies>> {
            override fun onResult(value: ArrayList<ListMovies>) {
                homeBasicStructureLiveData.postValue(value)
            }
        })
    }

    fun fetchDataListById(_idList: String): ArrayList<String> {
        var value1: ArrayList<String> = ArrayList()
        repository.getListMovieById(_idList, object : CallBack<ArrayList<String>> {
            override fun onResult(value: ArrayList<String>) {
                //побоялся использовать лайвдату, запросы по времени рядом, канал один, может быть каша
                value1 = value
            }
        })
        return value1
    }
}