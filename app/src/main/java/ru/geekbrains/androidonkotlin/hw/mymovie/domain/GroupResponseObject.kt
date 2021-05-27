package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import androidx.lifecycle.MutableLiveData

data class GroupResponseObject(
    val nameGroupResponse: String? = null,                // гаименование группы
    val standardList: String? = null,                     // ключевое поле для отбора данных группы
    val FuncFetch: (
        standard_list: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) -> Unit                                                        // функция отбора данных
) {
    val currentLiveData = MutableLiveData<ArrayList<MovieTMDB>>()    //LD для адаптера
    var lastAnswer: MoviesResponseTMDB =
        MoviesResponseTMDB()                                         // последний ответ сервера
    val prepareListMovies: ArrayList<MovieTMDB> = arrayListOf()      // список обработанных данных
}

