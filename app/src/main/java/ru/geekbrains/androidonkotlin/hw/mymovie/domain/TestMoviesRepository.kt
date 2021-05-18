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
        ListMovies("topRated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("nowPlaying", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
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
        networkServiceTMDB.getNowPlayingMovies(
            3,
            TMDBAPIConstants.API_KEY_V3,
            1,
            TMDBAPIConstants.LANGUAGE_ANSWER
        )
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
        networkServiceTMDB.getUpcomingMovies(
            3,
            TMDBAPIConstants.API_KEY_V3,
            1,
            TMDBAPIConstants.LANGUAGE_ANSWER
        )
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
        networkServiceTMDB.getPopularMovies(
            3,
            TMDBAPIConstants.API_KEY_V3,
            1,
            TMDBAPIConstants.LANGUAGE_ANSWER
        )
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
        networkServiceTMDB.getTopRatedMovies(
            3,
            TMDBAPIConstants.API_KEY_V3,
            1,
            TMDBAPIConstants.LANGUAGE_ANSWER
        )
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

    override fun getDiscoveredMovies(title: String, page: Int, callBack: CallBack<MoviesResponseTMDB>) {
        networkServiceTMDB.getSimpleSearchMovies(
            3,
            TMDBAPIConstants.API_KEY_V3,
            page,
            TMDBAPIConstants.LANGUAGE_ANSWER,
            title,
            false
        )
            .enqueue(object : Callback<MoviesResponseTMDB> {
                override fun onResponse(
                    call: Call<MoviesResponseTMDB>,
                    response: Response<MoviesResponseTMDB>
                ) {
                    callBack.onResult(response.body()!!)
                }

                override fun onFailure(call: Call<MoviesResponseTMDB>, t: Throwable) {
                }
            })
    }
}