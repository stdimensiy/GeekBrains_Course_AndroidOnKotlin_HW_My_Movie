package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb

interface MovieRepository {
    fun getHomeFragmentStructure(callBack: CallBack<List<ListMovies>>)
    fun getRatingFragmentStructure(callBack: CallBack<List<ListMovies>>)
    fun getDiscoveredMovies(
        title: String,
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    )

    fun getStandardsList(
        standardList: String,
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int = 1,
        callBack: CallBack<MoviesResponseTmdb>
    )
}