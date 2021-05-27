package ru.geekbrains.androidonkotlin.hw.mymovie.domain

object TmdbApiConstants {

    /** API KEY  V3 */
    const val API_KEY_V3 = "aefbe34a550ff3229e1b71c60f4f16df"

    /** Рабочая (онования по умолчанию) версия API */
    const val DEFAULT_API_VERSION = 3

    /** Server endpoint  фдрес базового размещеия графического материала  */
    private const val IMAGE_SERVER_URL = "https://image.tmdb.org/t/p/"

    /** Poster size - разрешение постера - пока так, в дальнейшем в перечисление  */
    private const val POSTER_SIZE = "w500"

    /** language answer - язык ответа  */
    const val LANGUAGE_ANSWER = "ru-RU"

    /** форматная строка сборного адреса картинки  */
    const val POSTER_URL = "$IMAGE_SERVER_URL$POSTER_SIZE%1\$s"

    /** include_adult - признак включения в выборку фильмов для взрослых  */
    const val INCLUDE_ADULT = false

    /** временно полный запрос к гостевым выдвчам */
    const val TEMP_POPULAR_MOVIE =
        "https://api.themoviedb.org/3/movie/popular?api_key=aefbe34a550ff3229e1b71c60f4f16df&language&language=ru-RU"

    /** временно полный запрос к конфигурацилнным данным */
    const val TEMP_GETCONFIGURAT =
        "https://api.themoviedb.org/3/configuration?api_key=aefbe34a550ff3229e1b71c60f4f16df&language"
}