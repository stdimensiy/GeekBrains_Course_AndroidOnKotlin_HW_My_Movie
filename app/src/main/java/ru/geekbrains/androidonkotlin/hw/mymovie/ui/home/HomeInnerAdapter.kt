package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeInnerAdapter(listId: String) : RecyclerView.Adapter<HomeInnerViewHolder>() {
    var items: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        return HomeInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeInnerViewHolder, position: Int) {
        var item = items.get(position)
        holder.nameMovie.text = item
        holder.publicData.text = "2020"
        holder.rating.text = "6,9"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}