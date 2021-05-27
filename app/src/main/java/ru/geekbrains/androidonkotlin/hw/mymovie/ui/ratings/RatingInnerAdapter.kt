package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class RatingInnerAdapter : RecyclerView.Adapter<RatingInnerViewHolder>() {
    var items: List<MovieTmdb> = listOf()
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        return RatingInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingInnerViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.nameMovie.text = item.title
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, item.posterPath))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        if (!item.releaseDate.isBlank()) {
            holder.publicData.text = item.releaseDate.trim().substring(0, 4)
        } else {
            holder.publicData.text = "0000"
        }
        holder.rating.text = item.voteAverage.toString()
        if (items.isNotEmpty() && position == items.size - 1) {
            onLoadMoreMoviesListener!!.onLoadMore()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }
}