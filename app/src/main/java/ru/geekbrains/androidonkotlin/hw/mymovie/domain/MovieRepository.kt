package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface MovieRepository {
    fun getFavoriteList(callBack: CallBack<MutableList<TestMovie>>)
    fun getHomeFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>)
    fun getRatingFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>)
    fun getDiscoveredMovies(title: String, page: Int, callBack: CallBack<MoviesResponseTMDB>)
    fun getStandardsLists(
        standard_list: String,
        page: Int = 1,
        callBack: CallBack<MoviesResponseTMDB>
    )
}