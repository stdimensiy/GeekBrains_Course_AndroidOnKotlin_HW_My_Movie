package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb

class RatingInnerViewHolder(
    itemView: View,
    val nameMovie: TextView = itemView.findViewById(R.id.textView_name_movie_for_common_horizontal_list_item),
    val publicData: TextView = itemView.findViewById(R.id.textView_date_release_movie_for_common_horizontal_list_item),
    val rating: TextView = itemView.findViewById(R.id.textView_rating_movie_for_common_horizontal_list_item),
    val imageViewPoster: ImageView = itemView.findViewById(R.id.imageView_poster_for_common_horizontal_list_item),
    private val imageViewRating: ImageView = itemView.findViewById(R.id.imageView_rating_movie_for_common_horizontal_list_item),
    private val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageView_flag_added_to_favorites_moviee_for_common_horizontal_list_item)
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: MovieTmdb) {
        imageViewPoster.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("ARG_MOVIE", item)
            itemView.findNavController().navigate(R.id.moreDetailedFragment, bundle)
        }

        imageViewRating.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_heart, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }

        imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}