package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.OnLoadMoreMovies

class HomeInnerAdapter : RecyclerView.Adapter<HomeInnerViewHolder>() {
    var items: List<MovieTmdb> = listOf()
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        return HomeInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeInnerViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.nameMovie.text = item.title
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, item.poster_path))
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