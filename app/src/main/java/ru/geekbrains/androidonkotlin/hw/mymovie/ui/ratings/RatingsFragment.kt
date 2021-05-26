package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingsFragment : Fragment() {

    private lateinit var ratingsViewModel: RatingsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ratingsViewModel =
                ViewModelProvider(this).get(RatingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ratings, container, false)
        val textView: TextView = root.findViewById(R.id.text_ratings)
        ratingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}