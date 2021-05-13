package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.`interface`.RetrofitServices
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.common.Common

class TestMoviesRepository : MovieRepository {
    var networkService: RetrofitServices = Common.retrofitService

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

    var ratingFragmentStructure: ArrayList<ListMovies> = arrayListOf(
        ListMovies(
            "1111",
            "Топ 100 зрительских симпатий",
            "Комментарий к подборке Топ 100 зрительских симпатий"
        ),
        ListMovies(
            "2222",
            "Топ 100 лучшей фантастики",
            "Комментарий к подборке Топ 100 лучшей фантастики"
        ),
        ListMovies(
            "3333",
            "Топ 100 лучших комедий",
            "Комментарий к подборке Топ 100 лучших комедий"
        ),
        ListMovies("4444", "Топ 100 детективов", "Комментарий к подборке Топ 100 детективов"),
        ListMovies("5555", "Топ 100 боевиков", "Комментарий к подборке Топ 100 боевиков"),
        ListMovies(
            "6666",
            "Топ 100 фильмов ужасов",
            "Комментарий к подборке Топ 100 фильмов ужасов"
        ),
        ListMovies(
            "7777",
            "Репйтинг научно-популярных фильмов",
            "Комментарий к подборке Репйтинг научно-популярных фильмов"
        ),
        ListMovies("8888", "Репйтинг сериалов", "Комментарий к подборке Репйтинг сериалов")
    )

    var rating1111lItems: ArrayList<String> = arrayListOf(
        "(рейт 111.) Первый фильм",
        "(рейт 111.) Второй фильм",
        "(рейт 111.) Третий фильм",
        "(рейт 111.) Четвертый фильм",
        "(рейт 111.) Пятый фильм",
        "(рейт 111.) Шестой фильм",
        "(рейт 111.) Седьмой фильм",
        "(рейт 111.) Восьмой фильм"
    )

    var rating2222lItems: ArrayList<String> = arrayListOf(
        "(рейт 222.) Первый фильм",
        "(рейт 222.) Второй фильм",
        "(рейт 222.) Третий фильм",
        "(рейт 222.) Четвертый фильм",
        "(рейт 222.) Пятый фильм",
        "(рейт 222.) Шестой фильм",
        "(рейт 222.) Седьмой фильм",
        "(рейт 222.) Восьмой фильм"
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

    var searchItems: ArrayList<String> = arrayListOf(
        "Рез. поиска - фильм 1",
        "Рез. поиска - фильм 2",
        "Рез. поиска - фильм 33",
        "Рез. поиска - фильм 44",
        "Рез. поиска - фильм 55",
        "Рез. поиска - фильм 666",
        "Рез. поиска - фильм 7777"
    )

    override fun getPopularList(callBack: CallBack<ArrayList<String>>) {
        callBack.onResult(testItems)
    }

    override fun getFavoriteList(callBack: CallBack<MutableList<TestMovie>>) {
        networkService.getMovieList().enqueue(object : Callback<MutableList<TestMovie>> {
            override fun onResponse(
                call: Call<MutableList<TestMovie>>,
                response: Response<MutableList<TestMovie>>
            ) {
                callBack.onResult(response.body()!!)
            }

            override fun onFailure(call: Call<MutableList<TestMovie>>, t: Throwable) {
            }
        })
    }

    override fun getHomeFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>) {
        callBack.onResult(homeFragmentStructure)
    }

    override fun getRatingFragmentStructure(callBack: CallBack<ArrayList<ListMovies>>) {
        callBack.onResult(ratingFragmentStructure)
    }

    override fun getListMovieById(listId: String, callBack: CallBack<ArrayList<String>>) {
        when (listId) {
            "first" -> callBack.onResult(populItems)
            "second" -> callBack.onResult(overItems)
            "1111" -> callBack.onResult(rating1111lItems)
            "2222" -> callBack.onResult(rating2222lItems)
            "3333" -> callBack.onResult(rating1111lItems)
            "4444" -> callBack.onResult(rating2222lItems)
            "5555" -> callBack.onResult(rating1111lItems)
            "6666" -> callBack.onResult(rating2222lItems)
            "7777" -> callBack.onResult(rating1111lItems)
            "8888" -> callBack.onResult(rating2222lItems)
        }
    }

    override fun getSearchList(searchPhrase: String, callBack: CallBack<ArrayList<String>>) {
        // тут будет логика отработки запроса
        callBack.onResult(searchItems)
    }
}