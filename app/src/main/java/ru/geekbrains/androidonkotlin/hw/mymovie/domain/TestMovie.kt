package ru.geekbrains.androidonkotlin.hw.mymovie.domain

/**
 * Класс TestMovie (создан для работы с API тестового сервиса)
 * тестовый класс для подключения к другому сервису.
 * Кандидат на удаление в ближайшее время.
 * @constructor создает объект, содержащий краткую общую информацию о фильме (тестовый сторонний сервис)
 */

data class TestMovie(
    var name: String? = null,
    var realname: String? = null,
    var team: String? = null,
    var firstapperance: String? = null,
    var createdby: String? = null,
    var publisher: String? = null,
    var imageurl: String? = null,
    var bio: String? = null
)