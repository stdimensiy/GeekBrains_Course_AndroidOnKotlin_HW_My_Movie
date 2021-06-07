package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingBasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val basicTitle: TextView = itemView.findViewById(R.id.basicTitle)
    var adapter: RatingInnerAdapter = RatingInnerAdapter()

    init {
        val ratingsInnerRecyclerView: RecyclerView = itemView.findViewById(R.id.home_inner_list)
        ratingsInnerRecyclerView.adapter = adapter
        ratingsInnerRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }
}