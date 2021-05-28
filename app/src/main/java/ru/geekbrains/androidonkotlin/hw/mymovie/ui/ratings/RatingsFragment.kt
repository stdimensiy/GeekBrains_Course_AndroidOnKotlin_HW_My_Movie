package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentRatingsBinding

class RatingsFragment : Fragment() {

    private lateinit var adapter: RatingBasicAdapter
    private val ratingsViewModel: RatingsViewModel by viewModels {
        RatingsViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentRatingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) ratingsViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRatingsBinding.inflate(inflater, container, false)
        val root = binding.root
        adapter = RatingBasicAdapter(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ratingBasicRecyclerView = binding.ratingBasicList
        ratingBasicRecyclerView.adapter = adapter
        ratingBasicRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        ratingsViewModel.ratingBasicStructureLiveData.observe(viewLifecycleOwner, {
            adapter.items = it
            if (savedInstanceState == null) {
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onPause() {
        super.onPause()
        ratingsViewModel.ratingBasicStructureLiveData.removeObservers(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}