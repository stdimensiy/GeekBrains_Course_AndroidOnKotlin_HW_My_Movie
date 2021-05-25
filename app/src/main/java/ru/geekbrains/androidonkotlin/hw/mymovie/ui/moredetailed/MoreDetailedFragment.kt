package ru.geekbrains.androidonkotlin.hw.mymovie.ui.moredetailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TMDBAPIConstants

class MoreDetailedFragment : Fragment() {
    lateinit var movie: MovieTMDB

    private lateinit var textViewNameMovie: TextView
    private lateinit var textViewOrigNameMovieAndData: TextView
    private lateinit var imageViewPoster: ImageView
    private lateinit var textViewDuration: TextView
    private lateinit var textViewRating: TextView
    private lateinit var tetextViewBudget: TextView
    private lateinit var textViewRevenue: TextView
    private lateinit var textViewReleaseData: TextView
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.more_detailed_fragment, container, false)
        textView = root.findViewById(R.id.text_moreDetailed)
        textViewNameMovie =
            root.findViewById(R.id.textView_moreDetail_nameMovie)            // Региональное наименование фильма
        textViewOrigNameMovieAndData =
            root.findViewById(R.id.textView_moreDetail_origNameMovieAndData) // Оригинальное наименование и (ГГГГ)
        imageViewPoster = root.findViewById(R.id.imageViewPoster)            // постер
        textViewDuration =
            root.findViewById(R.id.textView_moreDetail_duration)              // длительность мин.
        textViewRating =
            root.findViewById(R.id.textView_moreDetail_rating)                // рейтинг образец: 8,5 (7183)
        tetextViewBudget =
            root.findViewById(R.id.textView_moreDetail_budget)                 // Бюджет образец: 1 234 567 890 $
        textViewRevenue =
            root.findViewById(R.id.textView_moreDetail_revenue)                // Сборы: образец: 1 234 567 890 $
        textViewReleaseData =
            root.findViewById(R.id.textView_moreDetail_releaseData)            // Дата релиза образец: (2018-12-06)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = arguments?.getParcelable("ARG_MOVIE")!!
        textViewNameMovie.text = movie.title
        var currentReleaseData = "0000"
        if (!movie.release_date.isNullOrBlank()) {
            currentReleaseData = movie.release_date!!.trim().substring(0, 4)
        }
        (movie.original_title + " (" + currentReleaseData + ")").also {
            textViewOrigNameMovieAndData.text = it
        }
        Picasso.get()
            .load(String.format(TMDBAPIConstants.POSTER_URL, movie.poster_path))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(imageViewPoster)
        textViewDuration.text = "загрузка..."
        (movie.vote_average.toString() + " (" + movie.vote_count.toString() + ")").also {
            textViewRating.text = it
        }
        tetextViewBudget.text = "загрузка..."
        textViewRevenue.text = "загрузка..."
        ("(" + movie.release_date + ")").also { textViewReleaseData.text = it }
        textView.text = movie.overview
    }
}