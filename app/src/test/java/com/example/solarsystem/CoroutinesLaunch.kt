package com.example.solarsystem

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test

class CoroutinesLaunchTest {

    @Test
    fun startWithLaunchNoSleep() {
        println("Starting...")

        GlobalScope.launch {
            delay(1_000L)
            println("Inside...")
        }

        println("Stopping...")
    }

    @Test
    fun startWithLaunchSleep() {
        println("Starting...")

        GlobalScope.launch {
            delay(1_000L)
            println("Inside...")
        }

        Thread.sleep(1_500L)

        println("Stopping...")
    }

    @Test
    fun startWithLaunchMultiple() {

    }

    @Test
    fun startWithLaunchLazy() {

    }

}
