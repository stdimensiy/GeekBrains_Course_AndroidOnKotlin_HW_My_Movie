package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MoviesResponseTMDB

interface RetrofitServicesTMDB {
    /**
     * Now Playing Movies
     * @param api_version
     * @param key
     * @param page
     * @return Now Playing Movies
     */
    @GET("{api_version}/movie/now_playing?language=ru-RU")
    fun getNowPlayingMovies(
        @Path("api_version") api_version: Int,
        @Query("api_key") key: String,
        @Query("page") page: Int
    ): Call<MoviesResponseTMDB>
}