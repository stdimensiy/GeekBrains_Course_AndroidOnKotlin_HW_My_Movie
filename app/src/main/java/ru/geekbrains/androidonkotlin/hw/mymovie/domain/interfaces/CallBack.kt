package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces

interface CallBack<T> {
    fun onResult(value: T)
}