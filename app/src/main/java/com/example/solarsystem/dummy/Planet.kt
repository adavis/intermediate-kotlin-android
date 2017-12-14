package com.example.solarsystem.dummy

import com.example.solarsystem.GAS_GIANT
import com.example.solarsystem.TERRESTRIAL
import java.util.*

val Planet.composition: String
    get() = if (inner) TERRESTRIAL else GAS_GIANT

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