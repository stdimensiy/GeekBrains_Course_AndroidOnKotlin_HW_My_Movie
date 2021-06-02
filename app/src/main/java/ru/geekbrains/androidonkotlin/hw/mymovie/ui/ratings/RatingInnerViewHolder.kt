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
    val nameMovie: TextView = itemView.findViewById(R.id.textView2),
    val publicData: TextView = itemView.findViewById(R.id.textView3),
    val rating: TextView = itemView.findViewById(R.id.textView4),
    val imageViewPoster: ImageView = itemView.findViewById(R.id.imageView2),
    private val imageViewRating: ImageView = itemView.findViewById(R.id.imageView3),
    private val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewFlagFavoritesMovie)
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
                Toast.LENGTH_SHORT).show()
        }

        imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT).show()
        }
    }
}