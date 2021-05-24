package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.*

class RatingsViewModel : ViewModel() {

    private val repository: TestMoviesRepository = TestMoviesRepository()
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
    }
}