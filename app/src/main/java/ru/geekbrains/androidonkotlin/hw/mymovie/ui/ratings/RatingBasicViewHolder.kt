package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingBasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val basicTitle: TextView
    private lateinit var adapter: RatingInnerAdapter

    init {
        basicTitle = itemView.findViewById(R.id.basicTitle)
        adapter = RatingInnerAdapter()
        var homeInnerRecyclerView = itemView.findViewById<RecyclerView>(R.id.home_inner_list)
        homeInnerRecyclerView.adapter = adapter
        homeInnerRecyclerView.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }
}