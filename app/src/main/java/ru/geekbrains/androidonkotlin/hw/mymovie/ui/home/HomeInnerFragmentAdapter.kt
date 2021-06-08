package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class HomeInnerFragmentAdapter(_fragment: Fragment) : RecyclerView.Adapter<HomeInnerViewHolder>() {
    var items: List<MovieTmdb> = listOf()
    val fragment: Fragment = _fragment
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null
    private lateinit var defoultDataNull: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_horizontal_rv_type_one, parent, false)
        defoultDataNull = parent.context.getString(R.string.default_date_null)
        return HomeInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeInnerViewHolder, position: Int) {
        val item = items[position]
        //holder.bind(item)
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

    override fun onViewAttachedToWindow(holder: HomeInnerViewHolder) {
        val item = items[holder.adapterPosition]
        holder.imageViewPoster.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("ARG_MOVIE", item)
            holder.itemView.findNavController().navigate(R.id.moreDetailedFragment, bundle)
        }

        holder.imageViewRating.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_heart, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: HomeInnerViewHolder) {
        holder.imageViewPoster.setOnClickListener(null)
        holder.imageViewRating.setOnClickListener(null)
        holder.imageViewFlagFavoritesMovie.setOnClickListener(null)

        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int = items.size

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }
}