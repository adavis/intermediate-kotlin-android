package com.example.solarsystem

import org.junit.Test

fun doubleString(str: String): String {
    return str.repeat(2)
}

class NullabilityTest {

    @Test
    fun canNotBeNull() {
        var flavor: String = "mint"
//        flavor = null

        println(doubleString(flavor))
    }

    @Test
    fun canBeNull() {
        var flavor: String? = "mint"
        flavor = null

//        println(doubleString(flavor))
    }

    @Test
    fun ifNotNullCheck() {
        var flavor: String? = "mint"

        if (flavor != null) {
            println(doubleString(flavor))
        }
    }

    @Test
    fun letCheck() {
        var flavor: String? = null

        flavor?.let {
            println(doubleString(flavor))
        }
    }

    @Test
    fun elvisCheck() {
        var flavor: String? = null

        println(doubleString(flavor ?: "something else"))
    }

    @Test
    fun notNullAssertion() {
        var flavor: String? = null

        println(doubleString(flavor!!))
    }

}