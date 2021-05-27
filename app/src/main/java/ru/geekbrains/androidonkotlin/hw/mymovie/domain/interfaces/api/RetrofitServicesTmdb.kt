package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTmdb

interface RetrofitServicesTmdb {
    /**
     * Режим: Simple Search Movie - простой поиск фильмов на основе поисковой фразы
     * @param apiVersion ... - версия API с которой приято решение работать
     * @param key .......... - базовый ключ пользователя API key
     * @param page ......... - номер запрашиваемой страницы ( >=1 )
     * @param region ....... - регион поиска (пока отключен) код ISO 3166-1
     * @param language ..... - установка базового языка ответа
     * @param query ........ - поисковый запрос
     * @param includeAdult . - флаг включения в выборку фиильмов для взрослых
     * @return возвращает список фильмов в кинотеатрах...
     */
    @GET("{api_version}/search/movie")
    fun getSimpleSearchMovies(
        @Path("api_version") apiVersion: Int,
        @Query("api_key") key: String,
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean
        //@Query("region") region: String
    ): Call<MoviesResponseTmdb>

    /**
     * Раздел API: Movies
     * Режим standards lists (согласно документации есть только 4 стандартных листа now_playing, popular, top_rated и upcoming
     * @param apiVersion ... - версия API с которой приято решение работать
     * @param key .......... - базовый ключ пользователя API key
     * @param page ......... - номер запрашиваемой страницы ( >=1 )
     * @param region ....... - регион поиска (пока отключен) код ISO 3166-1
     * @param language ..... - установка базового языка ответа
     * @param standardList . - указатель стандартной выборки результатов (адрес относительно /movie/)
     * @param includeAdult . - флаг включения в выборку фиильмов для взрослых
     * @return возвращает список фиьмов с самым высоким рейтонгом по версии IMDB.
     */
    @GET("{api_version}/movie/{standard_list}")
    fun sectionMoviesGetStandardsLists(
        @Path("api_version") apiVersion: Int,
        @Path("standard_list") standardList: String,
        @Query("api_key") key: String,
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("include_adult") includeAdult: Boolean
        //@Query("region") region: String
    ): Call<MoviesResponseTmdb>
}