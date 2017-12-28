package com.example.solarsystem

import com.example.solarsystem.dummy.Planet
import com.example.solarsystem.dummy.PlanetsDataProvider
import org.junit.Test

class AggregateOperationsTest {

    private val planets = PlanetsDataProvider.ITEMS

    @Test
    fun fewestMoons() {
        val moons = planets.map(Planet::knownMoons)

        println(moons)
        println(moons.min())
    }

    @Test
    fun planetWithFewestMoons() {
        val planet = planets.minBy { it.knownMoons }

        println("$planet - ${planet?.knownMoons} moons")
    }

    @Test
    fun planetWithMostMoons() {
        val planet = planets.maxBy { it.knownMoons }

        println("$planet - ${planet?.knownMoons} moons")
    }

    @Test
    fun totalMoons() {
        val moons = planets.sumBy { it.knownMoons }

        println("$moons moons")
    }

}