package ru.geekbrains.androidonkotlin.hw.mymovie.ui.unwanted

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class UnwantedListFragment : Fragment() {

    companion object {
        fun newInstance() = UnwantedListFragment()
    }

    private lateinit var viewModel: UnwantedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.unwanted_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UnwantedListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}