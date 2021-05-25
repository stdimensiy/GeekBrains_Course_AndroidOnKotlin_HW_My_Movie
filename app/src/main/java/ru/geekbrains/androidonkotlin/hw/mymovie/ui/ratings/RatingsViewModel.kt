package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.*

class RatingsViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {

    //private val repository: TestMoviesRepository = TestMoviesRepository()
    val ratingBasicStructureLiveData = MutableLiveData<ArrayList<GroupResponseObject>>()
    var arrGroupList = ArrayList<GroupResponseObject>()

    fun fetchData() {
        repository.getRatingFragmentStructure(object : CallBack<ArrayList<ListMovies>> {
            override fun onResult(value: ArrayList<ListMovies>) {
                arrGroupList.clear()
                value.forEach {
                    arrGroupList.add(
                        GroupResponseObject(
                            it.listName,
                            it.listId,
                            ::fetchCurrentData
                        )
                    )
                }
                ratingBasicStructureLiveData.postValue(arrGroupList)
            }
        })
        arrGroupList.forEach { it.FuncFetch.invoke(it.standard_list.toString(), 1, it) }
        Log.v(
            "МОЯ ПРОВЕРКА",
            "Сработал fetchData"
        );
    }

    fun fetchCurrentData(
        standard_list: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) {
        repository.getStandardsLists(standard_list, page, object : CallBack<ArrayList<MovieTMDB>> {
            override fun onResult(value: ArrayList<MovieTMDB>) {
                currentGroupResponseObject.currentLiveData.postValue(value)
            }
        })
        Log.v(
            "МОЯ ПРОВЕРКА",
            "Сработал fetchCurrentData с данными standard_list: " + standard_list + " page: "+ page+ " currentGroupResponseObject: " + currentGroupResponseObject
        );
    }
}