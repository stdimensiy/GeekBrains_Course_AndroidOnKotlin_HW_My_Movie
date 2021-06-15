package ru.geekbrains.androidonkotlin.hw.mymovie.ui.unwanted

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class UnwantedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewNameFavoritesMovie)
    val textViewReleaseDataUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseDataFavoritesMovie)
    val textViewGenresUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewGenresFavoritesMovie)
    val textViewRatingUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewRatingFavoritesMovie)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_movie_details_poster)
    val imageViewFlagUnwantedMovie: ImageView =
        itemView.findViewById(R.id.imageView_flag_added_to_favorites_moviee_for_common_horizontal_list_item)
    val imageViewRatingUnwantedMovie: ImageView =
        itemView.findViewById(R.id.imageViewRatingFavoritesMovie)
}