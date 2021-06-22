package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.androidonkotlin.hw.mymovie.di.App
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.LocalRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.MovieRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.room.HistoryDao
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.room.SearchHistory

class TestMoviesRepository : MovieRepository, LocalRepository {
    private val historyDao: HistoryDao = App.getDb().historyDao()
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
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    ) {
        networkServiceTmdb.getSimpleSearchMovies(
            TmdbApiConstants.DEFAULT_API_VERSION,
            tmdbApiKeyV3,
            page,
            TmdbApiConstants.LANGUAGE_ANSWER,
            title,
            adultAdded
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
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    ) {
        networkServiceTmdb.sectionMoviesGetStandardsLists(
            TmdbApiConstants.DEFAULT_API_VERSION,
            standardList,
            tmdbApiKeyV3,
            page,
            TmdbApiConstants.LANGUAGE_ANSWER,
            adultAdded
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

//    override fun getAllHistorySearch(): List<SearchHistory> {
//        val localDataSource: HistoryDao = App.getDb().historyDao()
//        return localDataSource.all()
//    }

    override fun getAllHistorySearch(callBack: CallBack<List<SearchHistory>>) {
        val thread = object : Thread() {
            override fun run() {
                super.run()
                callBack.onResult(historyDao.all())
            }
        }
        thread.start()
    }

    override fun saveEntity(searchQuery: String) {
        val thread = object : Thread() {
            override fun run() {
                super.run()
                historyDao.insert(convertSearchQueryToSearchHistory(searchQuery))
            }
        }
        thread.start()
    }

    private fun convertSearchQueryToSearchHistory(searchQuery: String): SearchHistory {
        return SearchHistory(0, searchQuery)
    }
}