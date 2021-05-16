package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie

class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewNameFavoritesMovie)
    val textViewReleaseDataFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseDataFavoritesMovie)
    val textViewGenresFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewGenresFavoritesMovie)
    val textViewRatingFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewRatingFavoritesMovie)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageViewPoster)
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewFlagFavoritesMovie)
    val imageViewRatingFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewRatingFavoritesMovie)

    fun bind(item: TestMovie){
        imageViewPoster.setOnClickListener {
            Toast.makeText(it.context, "нажал на постер фильма ${item.name}, идентификатор фильма ${item.imageurl}", Toast.LENGTH_SHORT).show()
        }

        imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(it.context, "нажал на сердечко к фильму ${item.name}, идентификатор фильма ${item.imageurl}", Toast.LENGTH_SHORT).show()
        }

        imageViewRatingFavoritesMovie.setOnClickListener {
            Toast.makeText(it.context, "нажал на звездочку к фильму ${item.name}, идентификатор фильма ${item.imageurl}", Toast.LENGTH_SHORT).show()
        }
    }
}