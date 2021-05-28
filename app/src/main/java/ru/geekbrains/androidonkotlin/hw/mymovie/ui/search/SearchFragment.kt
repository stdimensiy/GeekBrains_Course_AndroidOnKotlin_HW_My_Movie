package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentSearchBinding
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class SearchFragment : Fragment() {
    private lateinit var adapter: SearchAdapter
    private val searchViewModel: SearchViewModel by viewModels {
        SearchViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private var searchString: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root = binding.root
        adapter = SearchAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchString = arguments?.getString("ARG_SEARCH", "")!!
        searchViewModel.fetchData(searchString)
        val searchRecyclerView = binding.searchList
        searchRecyclerView.adapter = adapter
        searchRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        searchViewModel.searchMovieLiveData.observe(viewLifecycleOwner, {
            adapter.items = searchViewModel.prepareListMovie
            adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    searchViewModel.fetchData(searchString)
                }
            })
            adapter.currentPage = it.page
            adapter.setTotalPages(it.totalPages)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onPause() {
        super.onPause()
        searchViewModel.searchMovieLiveData.removeObservers(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}