package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.GroupResponseObject

class RatingsViewModel(
    app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {

    val ratingBasicStructureLiveData = MutableLiveData<ArrayList<GroupResponseObject>>()
    var arrGroupList = ArrayList<GroupResponseObject>()

    private val preferenceManager = PreferenceManager.getDefaultSharedPreferences(app)
    private var tmdbApiKeyV3: String = preferenceManager.getString("tmdbApiKeyV3", "").toString()
    private var adultAdded = !preferenceManager.getBoolean("adultAdded", true)
    private var excludeMoviesWithoutPoster =
        preferenceManager.getBoolean("excludeMoviesWithoutPoster", true)
    private var excludeMoviesWithoutReleaseData =
        preferenceManager.getBoolean("excludeMoviesWithoutReleaseData", true)


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
        repository.getStandardsList(
            standardList,
            tmdbApiKeyV3,
            adultAdded,
            page,
            object : CallBack<MoviesResponseTmdb> {
                override fun onResult(value: MoviesResponseTmdb) {
                    //получая новую порцию данных обрабатываем её дополнительно по критериям пригодности к отображению
                    // критерии будут определены позже, поэтому сейчас список добавляется к текущему
                    // защита от дублирующих данных
                    if (currentGroupResponseObject.lastAnswer.page < value.page) {
                        // запись и обработка пришедших данных осуществляется только тогда,
                        // когда номерр страницы нового ответа больше чем предыдущего.
                        currentGroupResponseObject.lastAnswer = value
                        currentGroupResponseObject.prepareListMovies.addAll(value.results)
                        currentGroupResponseObject.currentLiveData.postValue(
                            currentGroupResponseObject.prepareListMovies
                        )
                    }
                }
            })
    }
}