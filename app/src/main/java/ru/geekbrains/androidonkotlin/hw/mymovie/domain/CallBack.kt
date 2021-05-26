package ru.geekbrains.androidonkotlin.hw.mymovie.domain

interface CallBack<T> {
    fun onResult(value: T)
}