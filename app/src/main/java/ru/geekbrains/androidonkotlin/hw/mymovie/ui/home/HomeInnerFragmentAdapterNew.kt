package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class HomeInnerFragmentAdapterNew(_fragment: Fragment) : RecyclerView.Adapter<HomeInnerViewHolderNew>() {
    var items: List<MovieTmdb> = listOf()
    val fragment: Fragment = _fragment
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null
    private lateinit var defoultDataNull: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeInnerViewHolderNew {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        defoultDataNull = parent.context.getString(R.string.default_date_null)
        return HomeInnerViewHolderNew(root)
    }

    override fun onBindViewHolder(holder: HomeInnerViewHolderNew, position: Int) {
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
        if (!item.releaseDate.isNullOrBlank()) {
            holder.publicData.text = item.releaseDate.trim().substring(0, 4)
        } else {
            holder.publicData.text = defoultDataNull
        }
        holder.rating.text = item.voteAverage.toString()
        if (items.size > 0 && position == items.size - 1) {
            onLoadMoreMoviesListener!!.onLoadMore()
        }
    }

    override fun getItemCount(): Int = items.size

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }
}