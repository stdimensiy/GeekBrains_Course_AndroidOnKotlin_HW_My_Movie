package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTMDB

interface RetrofitServicesTMDB {
    /**
     * Режим: Now Playing Movies
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @return возвращает список фильмов в кинотеатрах...
     */
    @GET("{api_version}/movie/now_playing?language=ru-RU")
    fun getNowPlayingMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        //@Query("region") region: String        // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>

    /**
     * Режим: Popular Movies (IMDB)
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @return возвращает список текущих популярных фильмов на IMDB. Этот список обновляется ежедневно.
     */
    @GET("{api_version}/movie/popular?language=ru-RU")
    fun getPopularMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        //@Query("region") region: String            // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>

    /**
     * Режим: Upcoming Movies
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @return возвращает список ожидаемых фильмов на IMDB.
     */
    @GET("{api_version}/movie/upcoming?language=ru-RU")
    fun getUpcomingMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        //@Query("region") region: String            // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>

    /**
     * Режим: Top Rated Movies
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @return возвращает список фиьмов с самым высоким рейтонгом по версии IMDB.
     */
    @GET("{api_version}/movie/top_rated?language=ru-RU")
    fun getTopRatedMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        //@Query("region") region: String            // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>
}