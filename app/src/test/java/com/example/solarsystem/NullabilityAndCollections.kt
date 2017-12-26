package com.example.solarsystem

import org.junit.Test

class NullabilityAndCollectionsTest {

    @Test
    fun listCannotBeNull() {
//        var flavors: List<String> = listOf("vanilla", "strawberry")
//        flavors = null
//
//        flavors.forEach { println(it) }
    }

    @Test
    fun listCanBeNull() {
        var flavors: List<String>? = listOf("vanilla", "strawberry")
        flavors = null

        flavors?.forEach { println(it) }
    }

    @Test
    fun valuesCannotBeNull() {
//        var flavors: List<String>? = listOf("vanilla", "strawberry", null)
//
//        flavors?.forEach { println(it) }
    }

    @Test
    fun valuesCanBeNull() {
        var flavors: List<String?>? = listOf("vanilla", "strawberry", null)

        flavors?.forEach { println(it) }
    }

}