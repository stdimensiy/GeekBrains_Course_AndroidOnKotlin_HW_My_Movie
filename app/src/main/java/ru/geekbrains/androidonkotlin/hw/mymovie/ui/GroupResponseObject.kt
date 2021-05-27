package ru.geekbrains.androidonkotlin.hw.mymovie.ui

import androidx.lifecycle.MutableLiveData
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb

/**
 * Класс GroupResponseObject (создан специально для UI для организации хранения данных во ViewModel)
 * отвечает за хранение результатов выборки для каждой конктерной группы
 * @param nameGroupResponse ..... - Наименование подборки (возвращается из репозитория)
 * @param standardList .......... - Строка - ключ стандартной выборки (см. API строку запроса)
 * @param funcFetch ............. - Ссылка на функцию запроса стандартной выборки и листа
 * @property currentLiveData .... - лайвдата для каждой конкретной выборки (влоенногого гориз. RV)
 * @property lastAnswer ......... - последний оригинальный ответ из репозитория (от сервера)
 * @property prepareListMovies .. - Список подготовленных (пригодных) к отображению данных
 * @constructor создает объект "хранитель оперативных данных" для каждой выборки
 */
data class GroupResponseObject(
    val nameGroupResponse: String? = null,
    val standardList: String? = null,
    val funcFetch: (
        standardList: String,
        page: Int,
        currentGroupResponseObject: GroupResponseObject
    ) -> Unit
) {
    val currentLiveData = MutableLiveData<List<MovieTmdb>>()
    var lastAnswer: MoviesResponseTmdb =
        MoviesResponseTmdb()
    val prepareListMovies: ArrayList<MovieTmdb> = arrayListOf()
}
