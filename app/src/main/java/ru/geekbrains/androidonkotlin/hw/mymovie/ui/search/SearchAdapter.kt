package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.OnLoadMoreMovies

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {
    var items: ArrayList<MovieTmdb> = arrayListOf()
    private var onLoadMoreMoviesListener: OnLoadMoreMovies? = null
    var currentPage: Int = 0         //номер текущей страницы выдачи
    private var totalPages: Int = 0  //всего страниц в выдаче

    init {
        this.currentPage = 1          //принудительная инициализация (всегда стартуем со страниы 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        //применена разметка от элемента списка избранных фильмов - сознательно. для экономии времени и проверки работоспособности.
        //пока он будет абсолютно таким-же, потом может заменю.
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return SearchViewHolder(root)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.textViewNameFavoritesMovie.text = item.title
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, item.poster_path))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.textViewGenresFavoritesMovie.text = "Какойто жанр, Драма, Задрама"
        holder.textViewRatingFavoritesMovie.text = item.vote_average.toString()
        if (item.release_date.isNullOrBlank()) holder.textViewReleaseDataFavoritesMovie.text =
            "(0000)"
        else ("(" + item.release_date.trim().subSequence(0, 4) + ") " + item.original_title)
            .also { holder.textViewReleaseDataFavoritesMovie.text = it }
        //попытка отследить момент необходимости загрузки нового листа данных
        if (currentPage < totalPages && position == items.size - 1) {
            Log.v(
                "МОЯ ПРОВЕРКА",
                "Пора грузить новый список (cp:" + currentPage + ", tp:" + totalPages + ")"
            );
            onLoadMoreMoviesListener!!.onLoadMore()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnLoadMoreMoviesListener(onLoadMoreMoviesListener: OnLoadMoreMovies) {
        this.onLoadMoreMoviesListener = onLoadMoreMoviesListener
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }
}