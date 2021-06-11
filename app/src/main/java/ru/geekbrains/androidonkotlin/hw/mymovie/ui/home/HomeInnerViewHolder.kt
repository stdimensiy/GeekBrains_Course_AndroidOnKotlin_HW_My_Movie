package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeInnerViewHolder(
    itemView: View,

) : RecyclerView.ViewHolder(itemView) {
    val nameMovie: TextView = itemView.findViewById(R.id.textView_name_movie_for_inner_item_holder_home)
    val publicData: TextView = itemView.findViewById(R.id.textView_date_release_movie_for_inner_item_holder_home)
    val rating: TextView = itemView.findViewById(R.id.textView_rating_movie_for_inner_item_holder_home)
    val imageViewPoster: ImageView = itemView.findViewById(R.id.imageView_poster_for_inner_item_holder_home)
    val imageViewRating: ImageView = itemView.findViewById(R.id.imageView_rating_movie_for_inner_item_holder_home)
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageView_flag_added_to_favorites_movie)
}

