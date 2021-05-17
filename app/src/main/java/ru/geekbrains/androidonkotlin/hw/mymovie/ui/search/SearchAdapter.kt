package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TMDBAPIConstants

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {
    var items: ArrayList<MovieTMDB> = arrayListOf(MovieTMDB())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        //применена разметка от элемента списка избранных фильмов - сознательно. для экономии времени и проверки работоспособности.
        //пока он будет абсолютно таким-же, потом может заменю.
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return SearchViewHolder(root)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.textViewNameFavoritesMovie.text = item.title
        Picasso.get()
            .load(String.format(TMDBAPIConstants.POSTER_URL, item.poster_path))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.textViewGenresFavoritesMovie.text = "Какойто жанр, Драма, Задрама"
        holder.textViewRatingFavoritesMovie.text = item.vote_average.toString()
        ("(" + item.release_date?.trim()?.subSequence(0, 4) + ") " + item.original_title)
            .also { holder.textViewReleaseDataFavoritesMovie.text = it }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}