package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.Contact

class ContactsListAdapter : RecyclerView.Adapter<ContactsListViewHolder>() {
    var items: List<Contact> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsListViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.contacts_list_item, parent, false)
        return ContactsListViewHolder(root)
    }

    override fun onBindViewHolder(holder: ContactsListViewHolder, position: Int) {
        val item = items[position]
        holder.textViewNameContact.text = item.displayName
    }

    override fun getItemCount(): Int = items.size

}