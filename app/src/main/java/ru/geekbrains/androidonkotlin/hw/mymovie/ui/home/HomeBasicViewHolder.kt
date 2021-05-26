package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeBasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val basicTitle: TextView
    private lateinit var adapter: HomeInnerAdapter

    init {
        basicTitle = itemView.findViewById(R.id.basicTitle)
        adapter = HomeInnerAdapter()
        var homeInnerRecyclerView = itemView.findViewById<RecyclerView>(R.id.home_inner_list)
        homeInnerRecyclerView.adapter = adapter
        homeInnerRecyclerView.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

    }
}