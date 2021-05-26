package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingBasicAdapter : RecyclerView.Adapter<RatingBasicViewHolder>() {
    var items: ArrayList<String> = arrayListOf(
        "Топ 100 зрительских симпатий",
        "Топ 100 лучшей фантастики",
        "Топ 100 лучших коммедий",
        "Топ 100 лучших детективов",
        "Топ 100 лучших боевиков",
        "Топ 100 лучших фильмов ужасов",
        "Рейтинг научно популярных фильмов",
        "Рейтинг сериалов"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingBasicViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.basic_item_home, parent, false)
        return RatingBasicViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingBasicViewHolder, position: Int) {
        var item = items.get(position)
        holder.basicTitle.text = item
    }

    override fun getItemCount(): Int {
        return items.size
    }
}