package ru.geekbrains.androidonkotlin.hw.mymovie.domain

/**
 * Класс ListMovies (создан для конфигурирования содержимого фрагментов)
 * отвечает за хранение результатов выборки для каждой конктерной группы
 * @param listName ..... - Наименование подборки (возвращается из репозитория)
 * @param listId ....... - Строка - ключ стандартной выборки (см. API строку запроса)
 * @param listTitle .... - Описание выборки (кратко)
 * @constructor создает объект (элемент) для организации данных списка списков (выборок) фильмов
 */
// в перспективе его нужно объединить с GroupResponseObject
data class ListMovies(
    val listId: String = "none",
    val listName: String = "noName",
    val listTitle: String = "noTitle"
)
