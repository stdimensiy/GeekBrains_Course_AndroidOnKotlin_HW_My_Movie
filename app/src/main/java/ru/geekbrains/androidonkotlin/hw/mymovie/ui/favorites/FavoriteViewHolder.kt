package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb

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

    fun bind(item: MovieTmdb) {
        imageViewPoster.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("ARG_MOVIE", item)
            itemView.findNavController().navigate(R.id.moreDetailedFragment, bundle)
        }

        imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_heart, item.title, item.id),
                Toast.LENGTH_SHORT).show()
        }

        imageViewRatingFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT).show()
        }
    }
}