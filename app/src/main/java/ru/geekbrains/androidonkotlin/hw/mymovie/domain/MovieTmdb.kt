package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Класс MovieTmdb (создан для работы с API TMDB)
 * отвечает за хранение общей информации объекта выборки (фильма в данном случае)
 * на тек. момент API предоставляет 14 полей для данного объекта
 * для детальной информации оо фильме передается другой объект с другим количеством полей,
 * и с другой информацией (бывает и так)
 * @param adult ............. - признак принадлежности фильма к категории "Для взрослых"
 * @param backdropPath ...... - ссылка на штатное изображение фона для данного фильма
 * @param genreIds .......... - список идентификаторов жанров, к которым относится фильм
 * @param id ................ - уникальный идентификатор фильма в базе
 * @param originalLanguage .. - оригинальный язык фильма (двухсимвольный стандарт, не Caps! (en)
 * @param originalTitle ..... - оригинальное наименоавние на оригинальном языке
 * @param overview .......... - краткое описание на установленном языке ответа (если есть)
 * @param popularity ........ - популярность (double)
 * @param posterPath ........ - ссылка на штатный постер локализованный относительно языка ответа
 * @param releaseDate ....... - дата релиза (может быть разной, в зависимости от выбранного региона)
 * @param title ............. - официальное наименование на языке ответа
 * @param video ............. - признак, есть ли к данному объекту (фильму) видео (трейлер)
 * @param voteAverage ....... - средний бал популярности (0-10) по версии TMDB
 * @param voteCount ......... - количество проголосовавших пользователей
 * @constructor создает объект, содержащий краткую общую информацию о фильме (TMDB API dthcbz 3)
 */

//PS @SerializedName сначала использовал только для полей с ненадлежащим наименованием (Snake case)
// затем решил использовать для всех полей, ибо случайно на рефакторинге можно получить проблему
// решение которой очень простое, но искать его долго.

// дополнительно установил большинство значений по умолчанию, избегая null

@Parcelize
data class MovieTmdb(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.toDouble(),
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Double = 0.toDouble(),
    @SerializedName("vote_count")
    val voteCount: Int = 0
) : Parcelable
