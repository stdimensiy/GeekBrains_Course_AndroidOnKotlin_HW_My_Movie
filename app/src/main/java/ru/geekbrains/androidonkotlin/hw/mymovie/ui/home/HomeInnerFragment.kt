package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.GroupResponseObject
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies


class HomeInnerFragment(private var groupResponseObject: GroupResponseObject? = null) : Fragment() {
    private lateinit var adapter: HomeInnerFragmentAdapterNew

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_inner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val testText: TextView = view.findViewById(R.id.test_text_inner_fragment)
        val innerRecyclerView: RecyclerView = view.findViewById(R.id.home_inner_list)
        adapter = HomeInnerFragmentAdapterNew(this)
        innerRecyclerView.adapter = adapter
        testText.text = groupResponseObject?.nameGroupResponse
        innerRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        groupResponseObject?.currentLiveData?.observe(viewLifecycleOwner, {
            adapter.items = it
            adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    if (groupResponseObject!!.lastAnswer.page < groupResponseObject!!.lastAnswer.totalPages) {
                        groupResponseObject!!.funcFetch.invoke(
                            groupResponseObject!!.standardList.toString(),
                            groupResponseObject!!.lastAnswer.page + 1, groupResponseObject!!
                        )
                    }
                }
            })
            adapter.notifyDataSetChanged()
        })
        super.onViewCreated(view, savedInstanceState)
    }
}