package com.rssoft.pokemongame.models

import android.location.Location
import com.google.android.gms.maps.model.LatLng

class Pokemon(
    var name: String,
    var description: String,
    var imageRes: Int,
    var power: Double,
    var position: LatLng,
    var isCaught: Boolean,
) {
    var location: Location? = null

    init {
        location = Location(name)
        location!!.longitude = position.longitude
        location!!.latitude = position.latitude
    }
}