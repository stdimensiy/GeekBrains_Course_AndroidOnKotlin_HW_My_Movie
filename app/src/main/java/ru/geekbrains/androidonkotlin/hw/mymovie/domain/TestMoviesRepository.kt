package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTest

class TestMoviesRepository : MovieRepository {
    var networkService: RetrofitServicesTest = Common.retrofitServiceTest
    var networkServiceTMDB: RetrofitServicesTMDB = Common.retrofitServiceTMDB
    var homeFragmentStructure: ArrayList<ListMovies> = arrayListOf(
        ListMovies("topRated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("nowPlaying", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
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

    override fun getNowPlayingMovies(callBack: CallBack<ArrayList<MovieTMDB>>) {
        networkServiceTMDB.getNowPlayingMovies(3, TMDBAPIConstants.API_KEY_V3, 1)
            .enqueue(object : Callback<MoviesResponseTMDB> {
                override fun onResponse(
                    call: Call<MoviesResponseTMDB>,
                    response: Response<MoviesResponseTMDB>
                ) {
                    callBack.onResult(response.body()?.results!!)
                }

                override fun onFailure(call: Call<MoviesResponseTMDB>, t: Throwable) {
                }
            })
    }

    override fun getUpcomingMovies(callBack: CallBack<ArrayList<MovieTMDB>>) {
        networkServiceTMDB.getUpcomingMovies(3, TMDBAPIConstants.API_KEY_V3, 1)
            .enqueue(object : Callback<MoviesResponseTMDB> {
                override fun onResponse(
                    call: Call<MoviesResponseTMDB>,
                    response: Response<MoviesResponseTMDB>
                ) {
                    callBack.onResult(response.body()?.results!!)
                }

                override fun onFailure(call: Call<MoviesResponseTMDB>, t: Throwable) {
                }
            })
    }

    override fun getPopularMovies(callBack: CallBack<ArrayList<MovieTMDB>>) {
        networkServiceTMDB.getPopularMovies(3, TMDBAPIConstants.API_KEY_V3, 1)
            .enqueue(object : Callback<MoviesResponseTMDB> {
                override fun onResponse(
                    call: Call<MoviesResponseTMDB>,
                    response: Response<MoviesResponseTMDB>
                ) {
                    callBack.onResult(response.body()?.results!!)
                }

                override fun onFailure(call: Call<MoviesResponseTMDB>, t: Throwable) {
                }
            })
    }

    override fun getTopRatedMovies(callBack: CallBack<ArrayList<MovieTMDB>>) {
        networkServiceTMDB.getTopRatedMovies(3, TMDBAPIConstants.API_KEY_V3, 1)
            .enqueue(object : Callback<MoviesResponseTMDB> {
                override fun onResponse(
                    call: Call<MoviesResponseTMDB>,
                    response: Response<MoviesResponseTMDB>
                ) {
                    callBack.onResult(response.body()?.results!!)
                }

                override fun onFailure(call: Call<MoviesResponseTMDB>, t: Throwable) {
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
}