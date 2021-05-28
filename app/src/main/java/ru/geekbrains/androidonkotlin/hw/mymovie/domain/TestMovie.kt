package ru.geekbrains.androidonkotlin.hw.mymovie.domain

/**
 * Класс TestMovie (создан для работы с API тестового сервиса)
 * тестовый класс для подключения к другому сервису.
 * Кандидат на удаление в ближайшее время.
 * @constructor создает объект, содержащий краткую общую информацию о фильме (тестовый сторонний сервис)
 */

data class TestMovie(
    val name: String? = null,
    val realname: String? = null,
    val team: String? = null,
    val firstapperance: String? = null,
    val createdby: String? = null,
    val publisher: String? = null,
    val imageurl: String? = null,
    val bio: String? = null
)