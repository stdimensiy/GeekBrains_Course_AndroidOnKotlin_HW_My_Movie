package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

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

class MarkedAaaListAdapter : RecyclerView.Adapter<MarkedAaaListViewHolder>() {
    var items: ArrayList<MovieTmdb> = arrayListOf()
    lateinit var genreStub: String
    lateinit var defoultDataNull: String
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null
    var currentPage: Int = 0         //номер текущей страницы выдачи
    private var totalPages: Int = 0  //всего страниц в выдаче

    init {
        this.currentPage = 1          //принудительная инициализация (всегда стартуем со страниы 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkedAaaListViewHolder {
        val root =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.common_vertical_list_item, parent, false)
        genreStub = parent.context.getString(R.string.genre_stub)
        defoultDataNull = parent.context.getString(R.string.default_date_null)
        return MarkedAaaListViewHolder(root)
    }

    override fun onBindViewHolder(holder: MarkedAaaListViewHolder, position: Int) {
        val item = items[position]
        holder.textViewNameMarkedAaaMovie.text = item.title
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, item.posterPath))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.textViewGenresMarkedAaaMovie.text = genreStub
        holder.textViewRatingMarkedAaaMovie.text = item.voteAverage.toString()
        if (item.releaseDate.isBlank()) holder.textViewReleaseDataMarkedAaaMovie.text =
            defoultDataNull
        else ("(${item.releaseDate.trim().subSequence(0, 4)}) ${item.originalTitle}")
            .also { holder.textViewReleaseDataMarkedAaaMovie.text = it }
        if (position == items.size - 1) {
            onLoadMoreMoviesListener!!.onLoadMore()
        }
    }

    override fun onViewAttachedToWindow(holder: MarkedAaaListViewHolder) {
        val item = items[holder.adapterPosition]
        holder.imageViewPoster.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("ARG_MOVIE", item)
            holder.itemView.findNavController().navigate(R.id.moreDetailedFragment, bundle)
        }

        holder.imageViewFlagMarkedAaaMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_heart, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.imageViewRatingMarkedAaaMovie.setOnClickListener {
            Toast.makeText(
                it.context,
                it.context.getString(R.string.default_text_action_for_star, item.title, item.id),
                Toast.LENGTH_SHORT
            ).show()
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: MarkedAaaListViewHolder) {
        holder.imageViewPoster.setOnClickListener(null)
        holder.imageViewFlagMarkedAaaMovie.setOnClickListener(null)
        holder.imageViewRatingMarkedAaaMovie.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int = items.size

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }
}