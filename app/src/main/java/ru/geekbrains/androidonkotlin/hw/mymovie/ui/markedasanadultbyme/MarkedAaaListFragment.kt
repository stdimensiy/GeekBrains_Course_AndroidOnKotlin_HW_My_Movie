package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class MarkedAaaListFragment : Fragment() {

    companion object {
        fun newInstance() = MarkedAaaListFragment()
    }

    private lateinit var viewModel: MarkedAaaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.marked_aaa_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarkedAaaListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}