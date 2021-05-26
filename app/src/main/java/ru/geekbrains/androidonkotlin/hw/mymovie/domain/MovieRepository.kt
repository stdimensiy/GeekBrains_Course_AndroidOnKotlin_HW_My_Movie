package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface MovieRepository {
    fun getFavoriteList(callBack: CallBack<List<TestMovie>>)
    fun getHomeFragmentStructure(callBack: CallBack<List<ListMovies>>)
    fun getRatingFragmentStructure(callBack: CallBack<List<ListMovies>>)
    fun getDiscoveredMovies(title: String, page: Int, callBack: CallBack<MoviesResponseTmdb>)
    fun getStandardsList(
        standardList: String,
        page: Int = 1,
        callBack: CallBack<MoviesResponseTmdb>
    )
}