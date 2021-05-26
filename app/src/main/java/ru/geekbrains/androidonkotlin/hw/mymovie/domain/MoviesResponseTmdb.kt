package ru.geekbrains.androidonkotlin.hw.mymovie.domain

data class MoviesResponseTmdb(
    val page: Int = 0,
    var results: ArrayList<MovieTmdb>? = null,
    val total_pages: Int = 0,
    val total_results: Int = 0
)