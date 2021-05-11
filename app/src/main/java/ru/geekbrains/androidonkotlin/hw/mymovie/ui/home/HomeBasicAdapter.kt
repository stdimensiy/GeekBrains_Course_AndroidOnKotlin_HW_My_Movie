package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies

class HomeBasicAdapter(_homeViewModel: HomeViewModel) :
    RecyclerView.Adapter<HomeBasicViewHolder>() {
    // не нашел пока другого способа
    val homeViewModel: HomeViewModel = _homeViewModel
    var items: ArrayList<ListMovies> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return HomeBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolder, position: Int) {
        //
        var item = items.get(position)
        // в зависимости от того что за позиция, запрашивается нужный список
        var currentIdList = item.listId // текущий идентификатор подборки
        // если я правильно понимаю адаптер запрашивать данные вообще не должне
        // онако они ему нужны, значит их нужно либо подготовить заранее либо впихнуть насильно
        // в крайнем случае я попробую запросить.
        var innerItems = homeViewModel.fetchDataListById(currentIdList)
        holder.basicTitle.text = item.listName
        //работа с вложенным адаптером
        holder.adapter.items.clear()
        holder.adapter.items.addAll(innerItems)
        holder.adapter.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}