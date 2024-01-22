package com.github.pavlovvladimir

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CompositionKtTest {
    private fun intToString(n: Int): String = n.toString()
    private fun stringToInt(s: String): Int = s.length
    private fun add10(n: Int): Int = n + 10

    /**
    The usual way looks val result = stringToInt(intToString(10))
     */
    @Test
    fun `test compose integer 100 to string to length of string should be 3`() {
        val result = ::intToString compose ::stringToInt // result here is function (n: Int) -> Int
        assertEquals(3, result(100))
    }

    @Test
    fun `test compose string hello to it's length to string should be 5`() {
        val result = ::stringToInt compose ::intToString // result here is function (s: String) -> String
        assertEquals("5", result("hello"))
    }

    @Test
    fun `test compose integer 100 to string to length of string and add 10 should be 13`() {
        val result = ::intToString compose ::stringToInt compose ::add10 // result here is function (n: Int) -> Int
        assertEquals(13, result(100))
    }

    @Test
    fun `test after string hello to it's length to string should be 5`() {
        val result = ::intToString after ::stringToInt // result here is function (String) -> String
        assertEquals("5", result("hello"))
    }

    @Test
    fun `test after integer 100 to string to length of string should be 3`() {
        val result = ::stringToInt after ::intToString // result here is function (Int) -> Int
        assertEquals(3, result(100))
    }

    @Test
    fun `test after string hello to integer then add 10 then to string should be 15`() {
        val result = ::intToString after ::add10 after ::stringToInt   // result here is function (String) -> String
        assertEquals("15", result("hello"))
    }
}