package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TMDBAPIConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.OnLoadMoreMovies

class RatingInnerAdapter : RecyclerView.Adapter<RatingInnerViewHolder>() {
    var items: ArrayList<MovieTMDB> = arrayListOf()
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
            .load(String.format(TMDBAPIConstants.POSTER_URL, item.poster_path))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.publicData.text = item.release_date?.trim()?.substring(0, 4)
        holder.rating.text = item.vote_average.toString()
        if (items.size > 0 && position == items.size - 1) {
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