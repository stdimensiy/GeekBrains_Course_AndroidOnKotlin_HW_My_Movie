package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface MovieRepository {
    fun getPopularList(callBack: CallBack<ArrayList<String>>)
    fun getFavoriteList(callBack: CallBack<ArrayList<String>>)
}