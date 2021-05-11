package ru.geekbrains.androidonkotlin.hw.mymovie.domain

class TestMoviesRepository : MovieRepository {
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

    var homeFragmentStructure: ArrayList<ListMovies> = arrayListOf(
        ListMovies("first", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("second", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
        ListMovies("first", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("first", "Лучшие", "Комментарий к подборке Лучшие")
    )

    var populItems: ArrayList<String> = arrayListOf(
        "(Попул.) Первый фильм",
        "(Попул.) Второй фильм",
        "(Попул.) Третий фильм",
        "(Попул.) Четвертый фильм",
        "(Попул.) Пятый фильм",
        "(Попул.) Шестой фильм",
        "(Попул.) Седьмой фильм",
        "(Попул.) Восьмой фильм"
    )

    var overItems: ArrayList<String> = arrayListOf(
        "(Ожид.) Первый фильм",
        "(Ожид.) Второй фильм",
        "(Ожид.) Третий фильм",
        "(Ожид.) Четвертый фильм",
        "(Ожид.) Пятый фильм",
        "(Ожид.) Шестой фильм",
        "(Ожид.) Седьмой фильм",
        "(Ожид.) Восьмой фильм"
    )

    override fun getPopularList(callBack: CallBack<ArrayList<String>>) {
        callBack.onResult(testItems)
    }

    override fun getFavoriteList(callBack: CallBack<ArrayList<String>>) {
        callBack.onResult(favoriteItems)
    }

    override fun getHomeFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>) {
        callBack.onResult(homeFragmentStructure)
    }

    override fun getListMovieById(listId: String, callBack: CallBack<java.util.ArrayList<String>>) {
        when (listId) {
            "first" -> callBack.onResult(populItems)
            "second" -> callBack.onResult(overItems)
        }
    }
}