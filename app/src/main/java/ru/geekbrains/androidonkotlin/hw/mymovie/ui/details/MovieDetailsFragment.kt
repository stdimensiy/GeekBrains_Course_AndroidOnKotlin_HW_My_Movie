package ru.geekbrains.androidonkotlin.hw.mymovie.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentMovieDetailsBinding
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.MovieTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TmdbApiConstants

class MovieDetailsFragment : Fragment() {
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels {
        MovieDetailsViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var movie: MovieTmdb
    private lateinit var textViewNameMovie: TextView             // Региональное наименование фильма
    private lateinit var textViewOrigNameMovieAndData: TextView  // Оригинальное наименование и (ГГГГ)
    private lateinit var imageViewPoster: ImageView              // постер
    private lateinit var textViewDuration: TextView              // длительность мин.
    private lateinit var textViewRating: TextView                // рейтинг образец: 8,5 (7183)
    private lateinit var tetextViewBudget: TextView              // Бюджет образец: 1 234 567 890 $
    private lateinit var textViewRevenue: TextView               // Сборы: образец: 1 234 567 890 $
    private lateinit var textViewReleaseData: TextView           // Дата релиза образец: (2018-12-06)
    private lateinit var textView: TextView

    lateinit var defoultDataNull: String
    lateinit var defaultPlugDownload: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textView = binding.textViewMovieDetailsDescription
        textViewNameMovie = binding.textViewMovieDetailsNameMovie
        textViewOrigNameMovieAndData = binding.textViewMovieDetailsOrigNameMovieAndData
        imageViewPoster = binding.imageViewMovieDetailsPoster
        textViewDuration = binding.textViewMovieDetailsDuration
        textViewRating = binding.textViewMovieDetailsRating
        tetextViewBudget = binding.textViewMovieDetailsBudget
        textViewRevenue = binding.textViewMovieDetailsRevenue
        textViewReleaseData = binding.textViewMovieDetailsReleaseData
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = arguments?.getParcelable("ARG_MOVIE")!!
        textViewNameMovie.text = movie.title
        defoultDataNull = view.context.getString(R.string.default_date_null)
        defaultPlugDownload = view.context.getString(R.string.default_plug_download)
        var currentReleaseData = defoultDataNull
        if (!movie.releaseDate.isBlank()) {
            currentReleaseData = movie.releaseDate.trim().substring(0, 4)
        }
        ("${movie.originalTitle} ($currentReleaseData)").also {
            textViewOrigNameMovieAndData.text = it
        }
        Picasso.get()
            .load(String.format(TmdbApiConstants.POSTER_URL, movie.posterPath))
            .placeholder(R.drawable.pholder)
            .error(R.drawable.err404)
            .resize(500, 750)
            .centerCrop()
            .into(imageViewPoster)
        textViewDuration.text = defaultPlugDownload
        ("${movie.voteAverage} (${movie.voteCount})").also {
            textViewRating.text = it
        }
        tetextViewBudget.text = defaultPlugDownload
        textViewRevenue.text = defaultPlugDownload
        ("(${movie.releaseDate})").also { textViewReleaseData.text = it }
        textView.text = movie.overview
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}