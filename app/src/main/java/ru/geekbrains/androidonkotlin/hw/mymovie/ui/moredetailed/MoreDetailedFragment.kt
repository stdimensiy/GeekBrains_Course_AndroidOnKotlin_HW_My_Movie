package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class MoreDetailedFragment : Fragment() {

    companion object {
        fun newInstance() = MoreDetailedFragment()
    }

    private lateinit var viewModel: MoreDetailedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MoreDetailedViewModel::class.java)
        val root  = inflater.inflate(R.layout.more_detailed_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_moreDetailed)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}