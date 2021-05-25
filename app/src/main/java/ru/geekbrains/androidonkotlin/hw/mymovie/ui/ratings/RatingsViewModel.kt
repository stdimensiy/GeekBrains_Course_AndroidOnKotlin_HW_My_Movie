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
        )
    }

    fun fetchCurrentData(
        standard_list: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) {
        repository.getStandardsLists(standard_list, page, object : CallBack<MoviesResponseTMDB> {
            override fun onResult(value: MoviesResponseTMDB) {
                //получая новую порцию данных обрабатываем её дополнительно по критериям пригодности к отображению
                // критерии будут определены позже, поэтому сейчас список добавляется к текущему
                // защита от дублирующих данных
                if (currentGroupResponseObject.lastAnswer.page < value.page) {
                    // запись и обработка пришедших данных осуществляется только тогда,
                    // когда номерр страницы нового ответа больше чем предыдущего.
                    currentGroupResponseObject.lastAnswer = value
                    currentGroupResponseObject.prepareListMovies.addAll(value.results!!)
                    currentGroupResponseObject.currentLiveData.postValue(currentGroupResponseObject.prepareListMovies)
                }
            }
        })
    }
}