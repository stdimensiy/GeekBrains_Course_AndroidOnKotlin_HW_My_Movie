package ru.geekbrains.androidonkotlin.hw.mymovie.ui.ratings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class RatingInnerAdapter : RecyclerView.Adapter<RatingInnerViewHolder>() {
    //временно создаем исходные данные непосредственно в адаптере, для проверки работоспособности
    var items: ArrayList<String> = arrayListOf(
        "Первый элем. рейтинга",
        "Второй элем. рейтинга",
        "Третий элем. рейтинга",
        "Четвертый элем. рейтинга",
        "Пятый элем. рейтинга",
        "Шестой элем. рейтинга",
        "Седьмой элем. рейтинга"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingInnerViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.inner_item_home, parent, false)
        return RatingInnerViewHolder(root)
    }

    override fun onBindViewHolder(holder: RatingInnerViewHolder, position: Int) {
        var item = items.get(position)
        holder.nameMovie.text = item
        holder.publicData.text = "2021"
        holder.rating.text = "8,9"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}