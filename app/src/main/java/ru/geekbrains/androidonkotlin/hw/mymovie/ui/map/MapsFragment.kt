package ru.geekbrains.androidonkotlin.hw.mymovie.ui.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import ru.geekbrains.androidonkotlin.hw.mymovie.R
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {
    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: GoogleMap
    private lateinit var markerCurrentPosition: Marker

    private val onLocationListener = LocationListener { location ->
        context?.let {
            Log.d("Моя проверка", "Сработал onLocationListener")

            val myGeoPosition = LatLng(location.latitude, location.longitude)
            //val myGeoPosition = LatLng(-34.0, 151.0)

            if(::markerCurrentPosition.isInitialized){
                markerCurrentPosition.remove()
            }
            markerCurrentPosition = map.addMarker(MarkerOptions().position(myGeoPosition).title("Marker in Sydney"))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(myGeoPosition, 15.0f))




        }

    }

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        Log.d("Моя проверка", "вызываю getLocation()")
        getLocation()
        map = googleMap
        //val sydney = LatLng(-34.0, 151.0)
        //googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun getLocation() {
        Log.d("Моя проверка", "Сработал getLocation()")
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
}