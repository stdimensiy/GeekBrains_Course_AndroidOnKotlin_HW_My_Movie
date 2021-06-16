package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.GroupResponseObject

class HomeBasicAdapter(_fragment: Fragment) :
    RecyclerView.Adapter<HomeBasicViewHolder>() {
    val fragment: Fragment = _fragment
    var items: ArrayList<GroupResponseObject> = ArrayList()
    private val fragmentManager: FragmentManager = fragment.childFragmentManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBasicViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return HomeBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolder, position: Int) {
        val item = items[position]
        holder.basicTitle.text = item.nameGroupResponse
        //работа с вложенным адаптером
        val currentLiveData: LiveData<List<MovieTmdb>> = item.currentLiveData
        currentLiveData.observeForever {
            holder.adapter.items = it
            holder.adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    if (item.lastAnswer.page < item.lastAnswer.totalPages) {
                        item.funcFetch.invoke(
                            item.standardList.toString(),
                            item.lastAnswer.page + 1, item
                        )
                    }
                }
            })
            holder.adapter.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onViewAttachedToWindow(holder: HomeBasicViewHolder) {
        attachFragmentToContainer(holder.flContainer.id, holder.adapterPosition)
        super.onViewAttachedToWindow(holder)
    }

    private fun attachFragmentToContainer(containerId: Int, fragmentListId: Int) {
        if (fragmentManager.findFragmentByTag(containerId.toString()) == null) {
            val fragment = HomeInnerFragment(items[fragmentListId])
            fragmentManager.beginTransaction().add(containerId, fragment, containerId.toString())
                .commitNowAllowingStateLoss()
        }
    }
}