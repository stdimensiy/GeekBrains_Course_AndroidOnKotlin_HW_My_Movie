package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.ContactsListFragmentBinding
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.Contact
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack

class ContactsListFragment : Fragment() {
    private var adapter: ContactsListAdapter = ContactsListAdapter()
    private val contactsListViewModel: ContactsListViewModel by viewModels {
        ContactsListViewModelFactory(requireActivity().application)
    }
    private var _binding: ContactsListFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactsListViewModel.fetchData(object : CallBack<List<Contact>> {
            override fun onResult(value: List<Contact>) {
                adapter.items = value
            }
        })
        val contactsListRecyclerView = binding.contactsList
        contactsListRecyclerView.adapter = adapter
        contactsListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}