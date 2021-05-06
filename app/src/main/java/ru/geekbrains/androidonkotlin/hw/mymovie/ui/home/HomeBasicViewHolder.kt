package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeBasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val basicTitle: TextView
    val basicContent: TextView
    init {
        basicTitle = itemView.findViewById(R.id.basicTitle)
        basicContent = itemView.findViewById(R.id.basicContent)
        //потом тут можно навесить слушателей на события, пока так.
    }
}