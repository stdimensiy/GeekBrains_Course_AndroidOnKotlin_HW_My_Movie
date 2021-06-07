package ru.geekbrains.androidonkotlin.hw.mymovie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeBasicAdapter
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) homeViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        adapter = HomeBasicAdapter(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBasicRecyclerView = binding.homeBasicList
        homeBasicRecyclerView.adapter = adapter
        homeBasicRecyclerView.setItemViewCacheSize(4)
        homeBasicRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        homeViewModel.homeBasicStructureLiveData.observe(viewLifecycleOwner, {
            adapter.items = it
            if (savedInstanceState == null) {
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onStop() {
        super.onStop()
        homeViewModel.homeBasicStructureLiveData.removeObservers(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}