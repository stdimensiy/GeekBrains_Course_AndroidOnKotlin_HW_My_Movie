package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.MovieRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTest
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTmdb

class TestMoviesRepository : MovieRepository {
    var networkService: RetrofitServicesTest = Common.retrofitServiceTest
    var networkServiceTmdb: RetrofitServicesTmdb = Common.retrofitServiceTmdb
    var homeFragmentStructure: List<ListMovies> = arrayListOf(
        ListMovies("top_rated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("now_playing", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
    )
    var ratingFragmentStructure: ArrayList<ListMovies> = arrayListOf(
        ListMovies("top_rated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("now_playing", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
    )

    override fun getFavoriteList(callBack: CallBack<List<TestMovie>>) {
        networkService.getMovieList().enqueue(object : Callback<List<TestMovie>> {
            override fun onResponse(
                call: Call<List<TestMovie>>,
                response: Response<List<TestMovie>>
            ) {
                callBack.onResult(response.body()!!)
            }

            override fun onFailure(call: Call<List<TestMovie>>, t: Throwable) {
            }
        })
    }

    override fun getHomeFragmentStructure(callBack: CallBack<List<ListMovies>>) {
        callBack.onResult(homeFragmentStructure)
    }

    override fun getRatingFragmentStructure(callBack: CallBack<List<ListMovies>>) {
        callBack.onResult(ratingFragmentStructure)
    }

    override fun getDiscoveredMovies(
        title: String,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    ) {
        networkServiceTmdb.getSimpleSearchMovies(
            TmdbApiConstants.DEFAULT_API_VERSION,
            TmdbApiConstants.API_KEY_V3,
            page,
            TmdbApiConstants.LANGUAGE_ANSWER,
            title,
            TmdbApiConstants.INCLUDE_ADULT
        )
            .enqueue(object : Callback<MoviesResponseTmdb> {
                override fun onResponse(
                    call: Call<MoviesResponseTmdb>,
                    response: Response<MoviesResponseTmdb>
                ) {
                    callBack.onResult(response.body()!!)
                }

                override fun onFailure(call: Call<MoviesResponseTmdb>, t: Throwable) {
                }
            })
    }

    override fun getStandardsList(
        standardList: String,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    ) {
        networkServiceTmdb.sectionMoviesGetStandardsLists(
            TmdbApiConstants.DEFAULT_API_VERSION,
            standardList,
            TmdbApiConstants.API_KEY_V3,
            page,
            TmdbApiConstants.LANGUAGE_ANSWER,
            TmdbApiConstants.INCLUDE_ADULT
        )
            .enqueue(object : Callback<MoviesResponseTmdb> {
                override fun onResponse(
                    call: Call<MoviesResponseTmdb>,
                    response: Response<MoviesResponseTmdb>
                ) {
                    callBack.onResult(response.body()!!)
                }

                override fun onFailure(call: Call<MoviesResponseTmdb>, t: Throwable) {
                }
            })
    }
}