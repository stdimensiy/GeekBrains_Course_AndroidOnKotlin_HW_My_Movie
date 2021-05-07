package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.home.HomeBasicAdapter

class RatingsFragment : Fragment() {

    private lateinit var ratingsViewModel: RatingsViewModel
    private lateinit var adapter: RatingBasicAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ratingsViewModel =
                ViewModelProvider(this).get(RatingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ratings, container, false)
//        val textView: TextView = root.findViewById(R.id.text_ratings)
//        ratingsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        adapter = RatingBasicAdapter()
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var ratingBasicRecyclerView = view.findViewById<RecyclerView>(R.id.rating_basic_list)
        ratingBasicRecyclerView.adapter = adapter
        ratingBasicRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}