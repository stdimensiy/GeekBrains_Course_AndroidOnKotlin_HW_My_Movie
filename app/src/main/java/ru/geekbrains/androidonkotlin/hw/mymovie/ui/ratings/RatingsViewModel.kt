package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.GroupResponseObject
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack

class RatingsViewModel(
    private val app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {

    val ratingBasicStructureLiveData = MutableLiveData<ArrayList<GroupResponseObject>>()
    var arrGroupList = ArrayList<GroupResponseObject>()

    fun fetchData() {
        repository.getRatingFragmentStructure(object : CallBack<List<ListMovies>> {
            override fun onResult(value: List<ListMovies>) {
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
        arrGroupList.forEach { it.funcFetch.invoke(it.standardList.toString(), 1, it) }
    }

    fun fetchCurrentData(
        standardList: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) {
        repository.getStandardsList(standardList, page, object : CallBack<MoviesResponseTmdb> {
            override fun onResult(value: MoviesResponseTmdb) {
                //получая новую порцию данных обрабатываем её дополнительно по критериям пригодности к отображению
                // критерии будут определены позже, поэтому сейчас список добавляется к текущему
                // защита от дублирующих данных
                if (currentGroupResponseObject.lastAnswer.page < value.page) {
                    // запись и обработка пришедших данных осуществляется только тогда,
                    // когда номерр страницы нового ответа больше чем предыдущего.
                    currentGroupResponseObject.lastAnswer = value
                    currentGroupResponseObject.prepareListMovies.addAll(value.results)
                    currentGroupResponseObject.currentLiveData.postValue(currentGroupResponseObject.prepareListMovies)
                }
            }
        })
    }
}