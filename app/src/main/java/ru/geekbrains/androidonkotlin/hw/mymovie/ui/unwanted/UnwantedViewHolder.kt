package ru.geekbrains.androidonkotlin.hw.mymovie.ui.unwanted

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class UnwantedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewName)
    val textViewReleaseDataUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewReleaseData)
    val textViewGenresUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewGenres)
    val textViewRatingUnwantedMovie: TextView =
        itemView.findViewById(R.id.textViewRating)
    val imageViewPoster: ImageView =
        itemView.findViewById(R.id.imageView_poster)
    val imageViewFlagUnwantedMovie: ImageView =
        itemView.findViewById(R.id.imageView_ingBtn_addToFavorites)
    val imageViewRatingUnwantedMovie: ImageView =
        itemView.findViewById(R.id.imageViewRating)
}