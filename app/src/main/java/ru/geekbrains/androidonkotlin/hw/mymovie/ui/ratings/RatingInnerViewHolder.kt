package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingInnerViewHolder(
    itemView: View,
    val nameMovie: TextView = itemView.findViewById(R.id.textView_name_movie_for_common_horizontal_list_item),
    val publicData: TextView = itemView.findViewById(R.id.textView_date_release_movie_for_common_horizontal_list_item),
    val rating: TextView = itemView.findViewById(R.id.textView_rating_movie_for_common_horizontal_list_item),
    val imageViewPoster: ImageView = itemView.findViewById(R.id.imageView_poster_for_common_horizontal_list_item),
    val imageViewRating: ImageView = itemView.findViewById(R.id.imageView_rating_movie_for_common_horizontal_list_item),
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageView_ingBtn_addToFavorites)
) : RecyclerView.ViewHolder(itemView)