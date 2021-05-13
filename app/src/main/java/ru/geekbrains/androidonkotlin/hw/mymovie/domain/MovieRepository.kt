package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface MovieRepository {
    fun getFavoriteList(callBack: CallBack<MutableList<TestMovie>>)
    fun getNowPlayingMovies(callBack: CallBack<ArrayList<MovieTMDB>>)
    fun getUpcomingMovies(callBack: CallBack<ArrayList<MovieTMDB>>)
    fun getPopularMovies(callBack: CallBack<ArrayList<MovieTMDB>>)
    fun getTopRatedMovies(callBack: CallBack<ArrayList<MovieTMDB>>)
    fun getHomeFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>)
    fun getRatingFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>)
    fun getListMovieById(listId: String, callBack: CallBack<java.util.ArrayList<String>>)
}