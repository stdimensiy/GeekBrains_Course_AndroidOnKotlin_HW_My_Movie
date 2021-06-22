package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class HistorySearchFragment : Fragment() {

    companion object {
        fun newInstance() = HistorySearchFragment()
    }

    private lateinit var viewModel: HistorySearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.history_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistorySearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}