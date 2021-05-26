package ru.geekbrains.androidonkotlin.hw.mymovie.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie

class FavoriteAdapter() : RecyclerView.Adapter<FavoriteViewHolder>() {
    var items: MutableList<TestMovie> = mutableListOf(TestMovie())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return FavoriteViewHolder(root)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.textViewNameFavoritesMovie.text = item.name
        Picasso.get()
            .load(item.imageurl)
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(holder.imageViewPoster)
        holder.textViewGenresFavoritesMovie.text = item.team
        holder.textViewRatingFavoritesMovie.text = "8,1"
        holder.textViewReleaseDataFavoritesMovie.text =
            "(" + item.createdby + ")" + " " + item.realname
    }

    override fun getItemCount(): Int {
        return items.size
    }
}