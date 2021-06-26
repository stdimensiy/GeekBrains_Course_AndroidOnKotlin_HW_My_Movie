package ru.geekbrains.androidonkotlin.hw.mymovie.ui.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.LocationFragmentBinding

class LocationFragment : Fragment() {

    private var _binding: LocationFragmentBinding? = null
    private val binding get() = _binding!!
    private val onLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d("Моя проверка", "Сработал слушатель")
            binding.locationValue.text =
                "Долгота " + location.latitude.toString() + " и широта " + location.longitude.toString()
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
        binding.locationValue.text = "Координаты пользователя"
        getLocation()
    }

    private fun getLocation() {
        Log.d("Моя проверка", "Мтартовал getLocation")
        activity?.let { context ->
            Log.d("Моя проверка", "Попытка создать локашон менеджер")
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Log.d("Моя проверка", "GPS_PROVIDER создан и велючен")
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
                        100f,
                        onLocationListener
                    )
                }
            } else {
                Log.d("Моя проверка", "GPS_PROVIDER НЕ СОЗДАН")
            }
        }
    }
}