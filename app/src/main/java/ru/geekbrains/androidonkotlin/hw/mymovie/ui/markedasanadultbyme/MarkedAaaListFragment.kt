package ru.geekbrains.androidonkotlin.hw.mymovie.ui.markedasanadultbyme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.MarkedAaaListFragmentBinding
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class MarkedAaaListFragment : Fragment() {
    private lateinit var adapter: MarkedAaaListAdapter
    private val markedAaaListViewModel: MarkedAaaListViewModel by viewModels {
        MarkedAaaListViewModelFactory(requireActivity().application)
    }
    private var _binding: MarkedAaaListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) markedAaaListViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MarkedAaaListFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        adapter = MarkedAaaListAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoriteRecyclerView = binding.MarkedAaaList
        favoriteRecyclerView.adapter = adapter
        favoriteRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        markedAaaListViewModel.favoritesMovieLiveData.observe(viewLifecycleOwner, {
            adapter.items = markedAaaListViewModel.prepareListMovies
            adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    markedAaaListViewModel.fetchData()
                }
            })
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        markedAaaListViewModel.favoritesMovieLiveData.removeObservers(viewLifecycleOwner)
        _binding = null
    }
}