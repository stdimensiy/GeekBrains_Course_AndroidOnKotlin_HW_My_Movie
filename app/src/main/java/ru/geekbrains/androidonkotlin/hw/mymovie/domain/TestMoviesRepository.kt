package ru.geekbrains.androidonkotlin.hw.mymovie.domain

class TestMoviesRepository: MovieRepository {
    var testItems: ArrayList<String> = arrayListOf(
        "Первый фильм",
        "Второй фильм",
        "Третий фильм",
        "Четвертый фильм",
        "Пятый фильм",
        "Шестой фильм",
        "Седьмой фильм",
        "Восьмой Избранный"
    )

    var favoriteItems: ArrayList<String> = arrayListOf(
        "(избранное) Первый фильм",
        "(избранное) Второй фильм",
        "(избранное) Третий фильм",
        "(избранное) Четвертый фильм",
        "(избранное) Пятый фильм",
        "(избранное) Шестой фильм",
        "(избранное) Седьмой фильм",
        "(избранное) Восьмой фильм"
    )

    override fun getPopularList(callBack: CallBack<ArrayList<String>>) {
        callBack.onResult(testItems)
    }

    override fun getFavoriteList(callBack: CallBack<ArrayList<String>>) {
        callBack.onResult(favoriteItems)
    }
}