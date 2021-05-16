package com.rssoft.pokemongame

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rssoft.pokemongame.models.Pokemon

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val locationAccessPermission = 123
    private var location: Location? = null
    private var oldLocation: Location? = null
    private val pokemons = arrayListOf<Pokemon>()
    private var playerPower: Double = 200.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()
        loadPokemons()
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    locationAccessPermission
                )
                return
            }
        }
        getUserLocation()
    }

    private fun getUserLocation() {
        val myLocationListener = MyLocationListener()
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        )
            return
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3,
            3f,
            myLocationListener
        )
        val myThread = MyThread()
        myThread.start()
    }

    private fun loadPokemons() {
        pokemons.add(
            Pokemon(
                "Charmander",
                "Fire Pokemon",
                R.drawable.charmander,
                185.0,
                LatLng(55.0, 37.778999),
                false,
            )
        )
        pokemons.add(
            Pokemon(
                "Bulbasaur",
                "Grass Pokemon",
                R.drawable.bulbasaur,
                222.0,
                LatLng(-15.0, 37.794956),
                false,
            )
        )
        pokemons.add(
            Pokemon(
                "Squirtle",
                "Water Pokemon",
                R.drawable.squirtle,
                122.0,
                LatLng(35.0, 37.78166),
                false,
            )
        )
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            locationAccessPermission -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getUserLocation()
                } else {
                    Toast.makeText(this, "Permission insufficient!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    inner class MyLocationListener : LocationListener {
        init {
            location = Location("Start")
            location!!.latitude = 0.0
            location!!.longitude = 0.0
        }

        override fun onLocationChanged(p0: Location) {
            location = p0
        }
    }

    inner class MyThread : Thread() {
        init {
            oldLocation = Location("Start")
            oldLocation!!.latitude = 21.0
            oldLocation!!.longitude = 0.0
        }

        override fun run() {
            while (true) {
                if (oldLocation!!.distanceTo(location) <= 20.0f)
                    continue
                println("Here")
                oldLocation = location
                try {
                    runOnUiThread {
                        mMap.clear()

                        //show me
                        val sydney = LatLng(location!!.latitude, location!!.longitude)
                        mMap.addMarker(
                            MarkerOptions()
                                .position(sydney)
                                .title("Me")
                                .snippet("My Location")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mario))
                        )
                        mMap.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                sydney,
                                6f
                            )
                        ) // 1f < zoom < 24f

                        //show pokemons
                        for (pokemon in pokemons) {
                            if (!pokemon.isCaught) {
                                mMap.addMarker(
                                    MarkerOptions()
                                        .position(pokemon.position)
                                        .title(pokemon.name)
                                        .snippet(pokemon.description + "\n" + pokemon.power)
                                        .icon(BitmapDescriptorFactory.fromResource(pokemon.imageRes))
                                )
                                if (pokemon.location!!.distanceTo(location) < 10f) {
                                    pokemon.isCaught = true
                                    playerPower += pokemon.power
                                    Toast.makeText(
                                        applicationContext,
                                        "Caught " + pokemon.name + ". New power = " + playerPower,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }
                    sleep(5000)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }
}