package com.rssoft.zoo.models

import java.io.Serializable

data class Animal(val name: String, val desc: String, val img: Int, val endangered: Boolean) :
    Serializable