package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class FavoriteAdapter() : RecyclerView.Adapter<FavoriteViewHolder>() {
    var items: ArrayList<MovieTmdb> = arrayListOf()
    lateinit var genreStub: String
    lateinit var defoultDataNull: String
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null
    var currentPage: Int = 0         //номер текущей страницы выдачи
    private var totalPages: Int = 0  //всего страниц в выдаче

    init {
        this.currentPage = 1          //принудительная инициализация (всегда стартуем со страниы 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        genreStub = parent.context.getString(R.string.genre_stub)
        defoultDataNull = parent.context.getString(R.string.default_date_null)
        return FavoriteViewHolder(root)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = items[position]
        holder.textViewNameFavoritesMovie.text = item.title
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, item.posterPath))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.textViewGenresFavoritesMovie.text = genreStub
        holder.textViewRatingFavoritesMovie.text = item.voteAverage.toString()
        if (item.releaseDate.isBlank()) holder.textViewReleaseDataFavoritesMovie.text =
            defoultDataNull
        else ("(" + item.releaseDate.trim().subSequence(0, 4) + ") " + item.originalTitle)
            .also { holder.textViewReleaseDataFavoritesMovie.text = it }
        if (position == items.size - 1) {
            onLoadMoreMoviesListener!!.onLoadMore()
        }
    }

    override fun onViewAttachedToWindow(holder: FavoriteViewHolder) {
        val item = items[holder.adapterPosition]
        holder.imageViewPoster.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("ARG_MOVIE", item)
            holder.itemView.findNavController().navigate(R.id.moreDetailedFragment, bundle)
        }

        holder.imageViewFlagFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_heart, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.imageViewRatingFavoritesMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: FavoriteViewHolder) {
        holder.imageViewPoster.setOnClickListener(null)
        holder.imageViewFlagFavoritesMovie.setOnClickListener(null)
        holder.imageViewRatingFavoritesMovie.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int = items.size

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }
}