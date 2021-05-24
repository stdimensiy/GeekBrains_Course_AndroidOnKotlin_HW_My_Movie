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
     * @param language - установка базового языка ответа
     * @return возвращает список фильмов в кинотеатрах...
     */
    @GET("{api_version}/movie/now_playing")
    fun getNowPlayingMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        @Query("language") language: String,   // установка базового языка ответа
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
    @GET("{api_version}/movie/popular")
    fun getPopularMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        @Query("language") language: String,   // установка базового языка ответа
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
    @GET("{api_version}/movie/upcoming")
    fun getUpcomingMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        @Query("language") language: String,   // установка базового языка ответа
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
    @GET("{api_version}/movie/top_rated")
    fun getTopRatedMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        @Query("language") language: String,   // установка базового языка ответа
        //@Query("region") region: String            // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>

    /**
     * Режим: Simple Search Movie - простой поиск фильмов на основе поисковой фразы
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @param language - установка базового языка ответа
     * @param query - поисковый запрос
     * @param include_adult - флаг включения в выборку фиильмов для взрослых
     * @return возвращает список фильмов в кинотеатрах...
     */
    @GET("{api_version}/search/movie")
    fun getSimpleSearchMovies(
        @Path("api_version") api_version: Int, // версия API с которой приято решение работать
        @Query("api_key") key: String,         // базовый ключ пользователя
        @Query("page") page: Int,              // номер страницы (их может быть много)
        @Query("language") language: String,   // установка базового языка ответа
        @Query("query") query: String,         // поисковая фраза
        @Query("include_adult") include_adult: Boolean    // признак наличия в выборке фильмов для взрослых
        //@Query("region") region: String        // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>

    /**
     * Раздел API: Movies
     * Режим standards lists (согласно документации есть только 4 стандартных листа now_playing, popular, top_rated и upcoming
     * @param api_version
     * @param key
     * @param page
     * @param region  - регион поиска (пока отключен)
     * @return возвращает список фиьмов с самым высоким рейтонгом по версии IMDB.
     */
    @GET("{api_version}/movie/{standard_list}")
    fun sectionMoviesGetStandardsLists(
        @Path("api_version") api_version: Int,        // версия API с которой приято решение работать
        @Path("standard_list") standard_list: String, // ытандартный лист (строго по API)
        @Query("api_key") key: String,                // базовый ключ пользователя
        @Query("page") page: Int,                     // номер страницы (их может быть много)
        @Query("language") language: String,          // установка базового языка ответа
        //@Query("region") region: String                   // код ISO 3166-1 для фильтрации дат выпуска. Должно быть в верхнем регистре
    ): Call<MoviesResponseTMDB>
}