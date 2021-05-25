package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.GroupResponseObject
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.OnLoadMoreMovies

class RatingBasicAdapter(_fragment: Fragment) :
    RecyclerView.Adapter<RatingBasicViewHolder>() {
    private val ratingsViewModel: RatingsViewModel =
        ViewModelProvider(_fragment).get(RatingsViewModel::class.java)
    val fragment: Fragment = _fragment
    var items: ArrayList<GroupResponseObject> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return RatingBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingBasicViewHolder, position: Int) {
        val item = items[position]
        holder.basicTitle.text = item.nameGroupResponse
        //работа с вложенным адаптером
        val currentRO = ratingsViewModel.arrGroupList[position]
        val currentLiveData: LiveData<ArrayList<MovieTMDB>> = currentRO.currentLiveData
        currentLiveData.observe(fragment.viewLifecycleOwner, Observer {
            holder.adapter.items = it
            holder.adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    if (currentRO.lastAnswer!!.page < currentRO.lastAnswer!!.total_pages) {
                        currentRO.FuncFetch.invoke(
                            currentRO.standard_list.toString(),
                            currentRO.lastAnswer!!.page + 1, currentRO
                        )
                    }
                }
            })
            holder.adapter.notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}