package com.example.solarsystem

import org.junit.Test

fun isEven(a: Int): String {
    return if (a % 2 == 0) {
        "it's even"
    } else {
        "it's odd"
    }
}

fun stringToInt(x: String) : Int {
    return try {
        x.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}

class ExpressionsTest {

    @Test
    fun ifAsExpression() {
        println(isEven(2))
        println(isEven(3))
    }

    @Test
    fun tryCatchAsExpression() {
        println(stringToInt("2"))
        println(stringToInt("cake"))
    }

}
