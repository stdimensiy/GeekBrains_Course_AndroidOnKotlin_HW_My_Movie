package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.room.SearchHistory

interface LocalRepository {
    fun getAllHistorySearch(callBack: CallBack<List<SearchHistory>>)
    fun saveEntity(searchQuery: String)
}