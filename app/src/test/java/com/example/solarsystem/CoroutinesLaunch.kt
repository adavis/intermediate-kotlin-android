package com.example.solarsystem

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.junit.Test

class CoroutinesLaunchTest {

    @Test
    fun startWithLaunchNoSleep() {
        println("Starting...")

        launch(CommonPool) {
            delay(1_000L)
            println("Inside...")
        }

        println("Stopping...")
    }

    @Test
    fun startWithLaunchSleep() {
        println("Starting...")

        launch(CommonPool) {
            delay(1_000L)
            println("Inside...")
        }

        Thread.sleep(1_500L)

        println("Stopping...")
    }

    @Test
    fun startWithLaunchMultiple() {
        println("Starting...")

        launch(CommonPool) {
            delay(1_000L)
            println("Inside 1...")
        }

        launch(CommonPool) {
            delay(1_000L)
            println("Inside 2...")
        }

        Thread.sleep(1_500L)

        println("Stopping...")
    }

    @Test
    fun startWithLaunchLazy() {
        println("Starting...")

        val job = launch(CommonPool, CoroutineStart.LAZY) {
            delay(1_000L)
            println("Inside...")
        }

        job.start()

        Thread.sleep(1_500L)

        println("Stopping...")
    }

}
