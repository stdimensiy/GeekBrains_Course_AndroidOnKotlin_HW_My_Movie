package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface MovieRepository {
    fun getPopularList(callBack: CallBack<ArrayList<String>>)
    fun getFavoriteList(callBack: CallBack<ArrayList<String>>)
    fun getHomeFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>)
    fun getListMovieById(listId: String, callBack: CallBack<java.util.ArrayList<String>>)
    fun getSearchList(searchPhrase: String, callBack: CallBack<ArrayList<String>>)
}