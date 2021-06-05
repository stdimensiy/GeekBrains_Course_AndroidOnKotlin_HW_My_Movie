package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeBasicViewHolderNew(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val basicTitle: TextView = itemView.findViewById(R.id.basicTitle)
    val flContainer: FrameLayout = itemView.findViewById(R.id.flContainer)
    //var adapter: HomeInnerAdapter = HomeInnerAdapter()

    init {
//        val homeInnerRecyclerView: RecyclerView =
//            itemView.findViewById(R.id.home_inner_list)
//        homeInnerRecyclerView.adapter = adapter
//        homeInnerRecyclerView.layoutManager =
//            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }
}