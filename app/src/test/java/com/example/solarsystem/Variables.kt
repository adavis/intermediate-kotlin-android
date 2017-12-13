package com.example.solarsystem

import org.junit.Test

class VariablesTest {

    @Test
    fun readOnly() {
        val flavor = "Vanilla"
//        flavor = "Mint"
    }

    @Test
    fun mutable() {
        var flavor = "Vanilla"
        flavor = "Mint"
    }
}