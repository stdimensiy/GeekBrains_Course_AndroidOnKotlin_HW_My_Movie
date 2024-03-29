package ru.geekbrains.androidonkotlin.hw.mymovie.ui.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.LocationFragmentBinding
import java.io.IOException

class LocationFragment : Fragment() {

    private var _binding: LocationFragmentBinding? = null
    private val binding get() = _binding!!
    private val onLocationListener = LocationListener { location ->
        binding.locationCoordinates.text = getString(
            R.string.default_text_location_coordinates,
            location.latitude.toString(),
            location.longitude.toString()
        )
        context?.let {
            getAddressAsync(it, location)
        }
    }
    private lateinit var viewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LocationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.locationCoordinates.text = getString(R.string.defaultLocationCoordinatesText)
        binding.locationAddress.text = getString(R.string.defaultLocationAddressText)
        getLocation()
    }

    private fun getLocation() {
        activity?.let { context ->
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                val provider = locationManager.getProvider(LocationManager.GPS_PROVIDER)
                provider?.let {
                    // дополнительная проверка разрешений, на всякий случай (требует система)
                    if (ActivityCompat.checkSelfPermission(
                            requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        // Если вдруг разрешения не получены (не должно срабатывать
                        // ибо в активити проверка выполнена)
                        return
                    }
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        6000L,
                        10f,
                        onLocationListener
                    )
                }
            } else {
                return
            }
        }
    }

    private fun getAddressAsync(
        context: Context,
        location: Location
    ) {
        val geoCoder = Geocoder(context)
        Thread {
            try {
                val addresses = geoCoder.getFromLocation(
                    location.latitude,
                    location.longitude,
                    1
                )
                binding.locationAddress.post {
                    binding.locationAddress.text = addresses[0].getAddressLine(0)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }
}