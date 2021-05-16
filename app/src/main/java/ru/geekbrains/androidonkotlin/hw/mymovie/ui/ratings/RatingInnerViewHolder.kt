package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB

class RatingInnerViewHolder(
    itemView: View,
    val nameMovie: TextView = itemView.findViewById(R.id.textView2),
    val publicData: TextView = itemView.findViewById(R.id.textView3),
    val rating: TextView = itemView.findViewById(R.id.textView4),
    val imageViewPoster: ImageView = itemView.findViewById(R.id.imageView2),
    val imageViewRating: ImageView = itemView.findViewById(R.id.imageView3),
    val imageViewFlagFavoritesMovie: ImageView =
        itemView.findViewById(R.id.imageViewFlagFavoritesMovie)
) : RecyclerView.ViewHolder(itemView){

    fun bind(item: MovieTMDB){
        imageViewPoster.setOnClickListener {
            Toast.makeText(it.context, "нажал на постер фильма ${item.title}, идентификатор фильма ${item.id}", Toast.LENGTH_SHORT).show()
        }

        imageViewRating.setOnClickListener {
            Toast.makeText(it.context, "нажал на звездочку к фильму ${item.title}, идентификатор фильма ${item.id}", Toast.LENGTH_SHORT).show()
        }

        imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(it.context, "нажал на сердечко к фильму ${item.title}, идентификатор фильма ${item.id}", Toast.LENGTH_SHORT).show()
        }
    }
}