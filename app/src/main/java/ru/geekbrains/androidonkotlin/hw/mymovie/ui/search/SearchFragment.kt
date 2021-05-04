package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.search_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_search)
        viewModel.text.observe(viewLifecycleOwner, Observer { textView.text = it })
        return root
    }
}