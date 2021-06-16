package ru.geekbrains.androidonkotlin.hw.mymovie.ui.unwanted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.UnwantedListFragmentBinding
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.interfaces.OnLoadMoreMovies

class UnwantedListFragment : Fragment() {
    private lateinit var adapter: UnwantedAdapter
    private val unwantedListViewModel: UnwantedListViewModel by viewModels {
        UnwantedListViewModelFactory(requireActivity().application)
    }
    private var _binding: UnwantedListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) unwantedListViewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UnwantedListFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        adapter = UnwantedAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoriteRecyclerView = binding.unwantedList
        favoriteRecyclerView.adapter = adapter
        favoriteRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        unwantedListViewModel.favoritesMovieLiveData.observe(viewLifecycleOwner, {
            adapter.items = unwantedListViewModel.prepareListMovies
            adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    unwantedListViewModel.fetchData()
                }
            })
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unwantedListViewModel.favoritesMovieLiveData.removeObservers(viewLifecycleOwner)
        _binding = null
    }
}