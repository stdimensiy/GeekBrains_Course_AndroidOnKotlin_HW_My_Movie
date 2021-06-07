package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.GroupResponseObject

class HomeBasicAdapterNew(_fragment: Fragment) :
    RecyclerView.Adapter<HomeBasicViewHolderNew>() {
    val fragment: Fragment = _fragment
    var items: ArrayList<GroupResponseObject> = ArrayList()
    private val fragmentManager: FragmentManager = fragment.childFragmentManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBasicViewHolderNew {
        Log.d("Моя проверка", "Сработал onCreateViewHolder parent: $parent , viewType $viewType")
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home_new, parent, false)
        return HomeBasicViewHolderNew(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolderNew, position: Int) {
        Log.d("Моя проверка", "Сработал onBindViewHolder , position $position")
        val item = items[position]
        holder.basicTitle.text = item.nameGroupResponse
        holder.flContainer.id = position + 100000
    }

    override fun getItemCount(): Int = items.size

    override fun onViewAttachedToWindow(holder: HomeBasicViewHolderNew) {
        Log.d(
            "Моя проверка",
            "Сработал onViewAttachedToWindow , position ${holder.adapterPosition}"
        )
        attachFragmentToContainer(holder.flContainer.id, holder.adapterPosition)
        super.onViewAttachedToWindow(holder)
    }

    private fun attachFragmentToContainer(containerId: Int, fragmentListId: Int) {
        if (fragmentManager.findFragmentByTag(containerId.toString()) == null) {
            Log.d("Моя проверка", "Фрагмента еще нет")
            val fragment = HomeInnerFragment(items[fragmentListId])
            fragmentManager.beginTransaction().add(containerId, fragment, containerId.toString())
                .commitNowAllowingStateLoss()
        } else {
            Log.d("Моя проверка", "Фрагмент есть")
        }
    }
}