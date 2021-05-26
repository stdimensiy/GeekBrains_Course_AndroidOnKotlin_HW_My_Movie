package ru.geekbrains.androidonkotlin.hw.mymovie.domain

data class Movie(
    var isAdult: Boolean = false,
    var backDropPath: String? = null,
    var budget: Int? = null,
    var genres: List<Int>? = null,
    var homepage: String? = null,
    var id: Int = 0,
    var imdb_id: String? = null, // есть валидация, нужно реализовать
    var original_language: String? = null,
    var original_title: String? = null,
    var overview: String? = null,
    var popularity: Double = 0.toDouble(),
    var poster_path: String? = null,
    var productionCompanies: List<Int>? = null,
    var productionCountries: List<Int>? = null,
    var release_date: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spoken_languages: List<String>? = null,
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var isVideo: Boolean = false,
    var vote_average: Double = 0.toDouble(),
    var vote_count: Int = 0,
)
