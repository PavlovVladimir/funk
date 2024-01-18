package com.github.pavlovvladimir

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

const val DEVELOPER = "developer"
const val ONE = 1

class PipesKtTest {
    private fun hello(name: String): String = "Hello $name"
    private fun add10(a: Int) = a + 10

    @Test
    fun `test string pipe`() {
        val result = DEVELOPER pipe ::hello
        assertEquals("Hello $DEVELOPER", result)
    }

    @Test
    fun `test int pipe`() {
        val result = ONE pipe ::add10
        assertEquals(11, result)
    }
}