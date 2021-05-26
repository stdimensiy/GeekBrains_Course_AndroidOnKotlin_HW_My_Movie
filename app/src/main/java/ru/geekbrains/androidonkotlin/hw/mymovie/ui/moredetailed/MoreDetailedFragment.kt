package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class MoreDetailedFragment : Fragment() {

    companion object {
        fun newInstance() = MoreDetailedFragment()
    }

    private lateinit var viewModel: MoreDetailedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MoreDetailedViewModel::class.java)
        val root = inflater.inflate(R.layout.more_detailed_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_moreDetailed)
        val textViewNameMovie: TextView =
            root.findViewById(R.id.textView_moreDetail_nameMovie)  // Региональное наименование фильма
        val textViewOrigNameMovieAndData: TextView =
            root.findViewById(R.id.textView_moreDetail_origNameMovieAndData) // Оригинальное наименование и (ГГГГ)
        val imageViewPoster: ImageView = root.findViewById(R.id.imageViewPoster) // постер
        val textViewDuration: TextView =
            root.findViewById(R.id.textView_moreDetail_duration) // длительность 125 мин.
        val textViewRating: TextView =
            root.findViewById(R.id.textView_moreDetail_rating) // рейтинг 8,5 (7183)
        val tetextViewBudget: TextView =
            root.findViewById(R.id.textView_moreDetail_budget) // Бюджет: 1 234 567 890 $
        val textViewRevenue: TextView =
            root.findViewById(R.id.textView_moreDetail_revenue) // Сборы: 1 234 567 890 $
        val textViewReleaseData: TextView =
            root.findViewById(R.id.textView_moreDetail_releaseData) // Дата релиза: (2018-12-06)
        //Фактически пока в разметку передаются только тестовка, для проверки скроллится ли текст
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}