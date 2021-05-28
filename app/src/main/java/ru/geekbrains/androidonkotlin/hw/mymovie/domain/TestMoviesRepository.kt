package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.MovieRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTmdb

class TestMoviesRepository : MovieRepository {
    private val networkServiceTmdb: RetrofitServicesTmdb = Common.retrofitServiceTmdb
    private val homeFragmentStructure: List<ListMovies> = listOf(
        ListMovies("top_rated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("now_playing", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
    )
    private val ratingFragmentStructure: List<ListMovies> = listOf(
        ListMovies("top_rated", "Лучшие", "Комментарий к подборке Лучшие"),
        ListMovies("popular", "Популярное", "Комментарий к подборке популярного"),
        ListMovies("now_playing", "Смотрят сейчас", "Комментарий к подборке Смотрят сейчас"),
        ListMovies("upcoming", "Ожидаемые", "Комментарий к подборке Ожидаемые"),
    )

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
                    response.body()?.let { callBack.onResult(it) }
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
                    response.body()?.let { callBack.onResult(it) }
                }

                override fun onFailure(call: Call<MoviesResponseTmdb>, t: Throwable) {
                }
            })
    }
}