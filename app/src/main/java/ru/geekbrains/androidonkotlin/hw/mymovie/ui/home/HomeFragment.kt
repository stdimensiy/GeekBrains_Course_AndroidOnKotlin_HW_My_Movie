package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeBasicAdapter
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(requireActivity().application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) homeViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        adapter = HomeBasicAdapter(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBasicRecyclerView = view.findViewById<RecyclerView>(R.id.home_basic_list)
        homeBasicRecyclerView.adapter = adapter
        homeBasicRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        homeViewModel.homeBasicStructureLiveData.observe(viewLifecycleOwner, Observer {
            adapter.items = it
            if (savedInstanceState == null) {
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onPause() {
        super.onPause()
        homeViewModel.homeBasicStructureLiveData.removeObservers(this)
    }
}