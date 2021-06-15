package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewName)
    val textViewReleaseDataFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseData)
    val textViewGenresFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewGenres)
    val textViewRatingFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewRating)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_poster)
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageView_ingBtn_addToFavorites)
    val imageViewRatingFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewRating)
}