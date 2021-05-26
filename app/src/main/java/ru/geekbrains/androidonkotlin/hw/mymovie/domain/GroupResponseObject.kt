package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import androidx.lifecycle.MutableLiveData

data class GroupResponseObject(
    val nameGroupResponse: String? = null,                // гаименование группы
    val standardList: String? = null,                     // ключевое поле для отбора данных группы
    val funcFetch: (
        standard_list: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) -> Unit                                                        // функция отбора данных
) {
    val currentLiveData = MutableLiveData<List<MovieTmdb>>()          //LD для адаптера
    var lastAnswer: MoviesResponseTmdb =
        MoviesResponseTmdb()                                         // последний ответ сервера
    val prepareListMovies: ArrayList<MovieTmdb> = arrayListOf()      // список обработанных данных
}

