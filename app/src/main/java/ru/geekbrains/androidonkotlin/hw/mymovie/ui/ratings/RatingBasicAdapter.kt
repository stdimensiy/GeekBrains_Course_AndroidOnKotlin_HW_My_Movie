package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies

class RatingBasicAdapter(_ratingViewModel: RatingsViewModel) :
    RecyclerView.Adapter<RatingBasicViewHolder>() {
    val ratingsViewModel: RatingsViewModel = _ratingViewModel
    var items: ArrayList<ListMovies> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return RatingBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingBasicViewHolder, position: Int) {
        val item = items.get(position)
        val currentIdList = item.listId
        val innerItems = ratingsViewModel.fetchDataListById(currentIdList)
        holder.basicTitle.text = item.listName
        holder.adapter.items.clear()
        holder.adapter.items.addAll(innerItems)
        holder.adapter.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}