package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingsFragment : Fragment() {

    private lateinit var ratingsViewModel: RatingsViewModel
    private lateinit var adapter: RatingBasicAdapter

    override fun onStart() {
        super.onStart()
        ratingsViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ratingsViewModel =
            ViewModelProvider(this).get(RatingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ratings, container, false)
        adapter = RatingBasicAdapter(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ratingBasicRecyclerView = view.findViewById<RecyclerView>(R.id.rating_basic_list)
        ratingBasicRecyclerView.adapter = adapter
        ratingBasicRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        ratingsViewModel.ratingBasicStructureLiveData.observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
    }
}