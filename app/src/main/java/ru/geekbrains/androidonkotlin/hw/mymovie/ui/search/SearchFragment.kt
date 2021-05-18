package ru.geekbrains.androidonkotlin.hw.mymovie.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.ui.OnLoadMoreMovies

class SearchFragment : Fragment() {
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var adapter: SearchAdapter
    var searchString: String = ""

    override fun onStart() {
        super.onStart()
        //searchViewModel.fetchData("")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.search_fragment, container, false)
        adapter = SearchAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchString = arguments?.getString("ARG_SEARCH", "")!!
        Toast.makeText(view.context, "Результат ввода посковой строки $searchString", Toast.LENGTH_SHORT).show()
        searchViewModel.fetchData(searchString)
        val searchRecyclerView = view.findViewById<RecyclerView>(R.id.search_list)
        searchRecyclerView.adapter = adapter
        searchRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        searchViewModel.searchMovieLiveData.observe(viewLifecycleOwner, Observer {
            // тут базово принимается решение о заполнении списка результатов
            // если объект пришел с индексом текущей страницы равным 1 значит это новый поисковый запрос
            // следовательно нужно старый список, что бы в нем не находилось, изничтожить
            if (it.page == 1) {
                adapter.items = it.results!!
            } else {
                adapter.items.addAll(it.results!!)
            }
            // иначе дополнить.
            adapter.setOnLoadMoreMoviesListener(object : OnLoadMoreMovies {
                override fun onLoadMore() {
                    searchViewModel.fetchData(searchString)
                }
            })
            adapter.currentPage = it.page
            adapter.setTotalPages(it.total_pages)
            adapter.notifyDataSetChanged()
        })
    }
}