package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TMDBAPIConstants

class RatingInnerAdapter : RecyclerView.Adapter<RatingInnerViewHolder>() {
    var items: ArrayList<MovieTMDB> = arrayListOf(MovieTMDB())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        return RatingInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingInnerViewHolder, position: Int) {
        val item = items[position]
        holder.nameMovie.text = item.title
        Picasso.get()
            .load(String.format(TMDBAPIConstants.POSTER_URL, item.poster_path))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.publicData.text = "2021"
        holder.rating.text = item.vote_average.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}