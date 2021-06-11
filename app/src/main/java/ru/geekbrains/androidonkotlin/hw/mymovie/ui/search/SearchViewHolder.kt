package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewNameFavoritesMovie)
    val textViewReleaseDataFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseDataFavoritesMovie)
    val textViewGenresFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewGenresFavoritesMovie)
    val textViewRatingFavoritesMovie: TextView =
        itemView.findViewById(R.id.textViewRatingFavoritesMovie)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_movie_details_poster)
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageView_flag_added_to_favorites_moviee_for_common_horizontal_list_item)
    val imageViewRatingFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewRatingFavoritesMovie)
}