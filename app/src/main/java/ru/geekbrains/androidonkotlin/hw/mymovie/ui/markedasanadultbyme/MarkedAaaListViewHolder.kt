package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class MarkedAaaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewNameFavoritesMovie)
    val textViewReleaseDataMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseDataFavoritesMovie)
    val textViewGenresMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewGenresFavoritesMovie)
    val textViewRatingMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewRatingFavoritesMovie)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_movie_details_poster)
    val imageViewFlagMarkedAaaMovie: ImageView =
        itemView.findViewById(R.id.imageView_flag_added_to_favorites_moviee_for_common_horizontal_list_item)
    val imageViewRatingMarkedAaaMovie: ImageView =
        itemView.findViewById(R.id.imageViewRatingFavoritesMovie)
}