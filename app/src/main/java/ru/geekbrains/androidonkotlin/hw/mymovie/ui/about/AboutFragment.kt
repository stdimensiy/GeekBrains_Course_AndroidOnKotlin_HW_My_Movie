package ru.geekbrains.androidonkotlin.hw.mymovie.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private val aboutViewModel: AboutViewModel by viewModels {
        AboutViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textAbout
        aboutViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onPause() {
        super.onPause()
        aboutViewModel.text.removeObservers(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}