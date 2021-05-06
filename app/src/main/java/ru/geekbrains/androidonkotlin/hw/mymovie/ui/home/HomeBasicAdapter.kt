package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeBasicAdapter : RecyclerView.Adapter<HomeBasicViewHolder>() {
    //временно создаем исходные данные непосредственно в адаптере, для проверки работоспособности
    var items: ArrayList<String> =
        arrayListOf("Первая рубрика", "Вторая рубрика", "Третья рубрика", "Четвертая рубрика")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return HomeBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolder, position: Int) {
        var item = items.get(position)
        holder.basicTitle.text = item
    }

    override fun getItemCount(): Int {
        return items.size
    }
}