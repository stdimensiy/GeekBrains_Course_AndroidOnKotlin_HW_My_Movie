package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.ListMovies
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB

class HomeBasicAdapter(_fragment: Fragment) :
    RecyclerView.Adapter<HomeBasicViewHolder>() {
    // не нашел пока другого способа
    val homeViewModel: HomeViewModel = ViewModelProvider(_fragment).get(HomeViewModel::class.java)
    val fragment: Fragment = _fragment
    var items: ArrayList<ListMovies> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return HomeBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolder, position: Int) {
        val item = items.get(position)
        // в зависимости от того что за позиция, запрашивается нужный список
        var currentIdList = item.listId // текущий идентификатор подборки
        holder.basicTitle.text = item.listName
        //работа с вложенным адаптером
        //подписываем каждую конкретную линейку на свою лайвдату
        var currentMutableLiveData: MutableLiveData<ArrayList<MovieTMDB>>
        currentMutableLiveData = homeViewModel.popularMovieLiveData
        when (item.listId) {
            "upcoming" -> currentMutableLiveData = homeViewModel.upcomingMovieLiveData
            "topRated" -> currentMutableLiveData = homeViewModel.topRatedMovieLiveData
            "nowPlaying" -> currentMutableLiveData = homeViewModel.nowPlayingMovieLiveData
        }
        currentMutableLiveData.observe(fragment.viewLifecycleOwner, Observer {
            holder.adapter.items = it
            holder.adapter.notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}