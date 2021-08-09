package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class ContactsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewNameContact: TextView =
        itemView.findViewById(R.id.textViewName)
}