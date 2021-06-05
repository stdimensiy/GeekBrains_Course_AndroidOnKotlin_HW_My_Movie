package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

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
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home_new, parent, false)
        return HomeBasicViewHolderNew(root)
    }

    override fun onBindViewHolder(holder: HomeBasicViewHolderNew, position: Int) {
        val item = items[position]
        holder.basicTitle.text = item.nameGroupResponse
        holder.flContainer.id = position + 100000
    }

    override fun getItemCount(): Int = items.size

    override fun onViewAttachedToWindow(holder: HomeBasicViewHolderNew) {
        attachFragmentToContainer(holder.flContainer.id)
        super.onViewAttachedToWindow(holder)
    }

    private fun attachFragmentToContainer(containerId: Int) {
        val fragment = HomeInnerFragment.newInstance("Первый парметр", "Второй параметр")
        fragmentManager.beginTransaction().add(containerId, fragment).commitNowAllowingStateLoss()
    }
}