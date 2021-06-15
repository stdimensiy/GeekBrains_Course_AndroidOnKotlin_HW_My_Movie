package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class MarkedAaaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewName)
    val textViewReleaseDataMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseData)
    val textViewGenresMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewGenres)
    val textViewRatingMarkedAaaMovie: TextView =
        itemView.findViewById(R.id.textViewRating)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_poster)
    val imageViewFlagMarkedAaaMovie: ImageView =
        itemView.findViewById(R.id.imageView_ingBtn_addToFavorites)
    val imageViewRatingMarkedAaaMovie: ImageView =
        itemView.findViewById(R.id.imageViewRating)
}