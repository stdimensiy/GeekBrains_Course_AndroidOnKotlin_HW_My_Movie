package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites.FavoriteViewHolder

class SearchAdapter : RecyclerView.Adapter<FavoriteViewHolder>() {
    //временно создаем исходные данные непосредственно в адаптере, для проверки работоспособности
    var items: ArrayList<String> = arrayListOf(
        "Рез. поиска - фильм 1",
        "Рез. поиска - фильм 2",
        "Рез. поиска - фильм 3",
        "Рез. поиска - фильм 4",
        "Рез. поиска - фильм 5",
        "Рез. поиска - фильм 6",
        "Рез. поиска - фильм 7"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return FavoriteViewHolder(root)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        var item = items.get(position)
        holder.textViewNameFavoritesMovie.text = item
        holder.textViewGenresFavoritesMovie.text = "Какойто жанр, Драма, Задрама"
        holder.textViewRatingFavoritesMovie.text = "8,1"
        holder.textViewReleaseDataFavoritesMovie.text = "2020 И еще чтототам..."
    }

    override fun getItemCount(): Int {
        return items.size
    }
}