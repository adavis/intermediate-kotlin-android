package com.example.solarsystem.dummy

import java.util.*

data class Planet(
        val id: String = UUID.randomUUID().toString(),
        val name: String = "",
        val inner: Boolean = false,
        val description: String = "",
        val knownMoons: Int = 0,
        val imageResourceId: Int = -1,
        val orbitalPeriod: Float = 0F
) {
    override fun toString(): String = name
}