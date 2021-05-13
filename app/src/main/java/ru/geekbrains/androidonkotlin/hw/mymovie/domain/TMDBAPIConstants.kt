package ru.geekbrains.androidonkotlin.hw.mymovie.domain

object TMDBAPIConstants {

    /** API KEY  V3 */
    val API_KEY_V3 = "aefbe34a550ff3229e1b71c60f4f16df"

    /** Server endpoint  фдрес базового размещеия графического материала  */
    val IMAGE_SERVER_URL = "https://image.tmdb.org/t/p/"

    /** Poster size - разрешение постера - пока так, в дальнейшем в перечисление  */
    val POSTER_SIZE = "w500"

    /** language answer - язык ответа  */
    val LANGUAGE_ANSWER = "ru_RU"

    /** форматная строка сборного адреса картинки  */
    val POSTER_URL = "$IMAGE_SERVER_URL$POSTER_SIZE%1\$s"

    /** временно полный запрос к гостевым выдвчам */
    val TEMP_POPULAR_MOVIE =
        "https://api.themoviedb.org/3/movie/popular?api_key=aefbe34a550ff3229e1b71c60f4f16df&language&language=ru-RU"

    /** временно полный запрос к конфигурацилнным данным */
    val TEMP_GETCONFIGURAT =
        "https://api.themoviedb.org/3/configuration?api_key=aefbe34a550ff3229e1b71c60f4f16df&language"
}