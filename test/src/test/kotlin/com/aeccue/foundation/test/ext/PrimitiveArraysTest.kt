package com.aeccue.foundation.test.ext

import org.junit.jupiter.api.Test

class PrimitiveArraysTest {

    @Test
    fun `asserting if two of the same boolean array are equal should succeed`() {
        val arrayOne = booleanArrayOf(true, false, false, true, false, false, true)
        val arrayTwo = booleanArrayOf(true, false, false, true, false, false, true)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different boolean arrays are not equal should succeed`() {
        val arrayOne = booleanArrayOf(true, false, false, true, false, false, true)
        val arrayTwo = booleanArrayOf(true, false, false, true, false, false, false)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same byte array are equal should succeed`() {
        val arrayOne = byteArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = byteArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different byte arrays are not equal should succeed`() {
        val arrayOne = byteArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = byteArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 14)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same char array are equal should succeed`() {
        val arrayOne = charArrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd')
        val arrayTwo = charArrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd')

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different char arrays are not equal should succeed`() {
        val arrayOne = charArrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd')
        val arrayTwo = charArrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd', '!')

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same double array are equal should succeed`() {
        val arrayOne = doubleArrayOf(1.5, 5.5, 15.2, 19.2, 100.4, 63.4, 523.2)
        val arrayTwo = doubleArrayOf(1.5, 5.5, 15.2, 19.2, 100.4, 63.4, 523.2)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different double arrays are not equal should succeed`() {
        val arrayOne = doubleArrayOf(1.5, 5.5, 15.2, 19.2, 100.4, 63.4, 523.2)
        val arrayTwo = doubleArrayOf(1.5, 5.5, 15.2, 19.2, 100.4, 63.4, 523.3)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same float array are equal should succeed`() {
        val arrayOne = floatArrayOf(1.5f, 5.5f, 15.2f, 19.2f, 100.4f, 63.4f, 523.2f)
        val arrayTwo = floatArrayOf(1.5f, 5.5f, 15.2f, 19.2f, 100.4f, 63.4f, 523.2f)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different float arrays are not equal should succeed`() {
        val arrayOne = floatArrayOf(1.5f, 5.5f, 15.2f, 19.2f, 100.4f, 63.4f, 523.2f)
        val arrayTwo = floatArrayOf(1.5f, 5.5f, 15.2f, 19.2f, 100.4f, 63.4f, 523.3f)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same int array are equal should succeed`() {
        val arrayOne = intArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = intArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different int arrays are not equal should succeed`() {
        val arrayOne = intArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = intArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 14)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same long array are equal should succeed`() {
        val arrayOne = longArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = longArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different long arrays are not equal should succeed`() {
        val arrayOne = longArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = longArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 14)

        arrayOne `contents should not be equal to` arrayTwo
    }

    @Test
    fun `asserting if two of the same short array are equal should succeed`() {
        val arrayOne = shortArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = shortArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)

        arrayOne `contents should be equal to` arrayTwo
    }

    @Test
    fun `asserting if two different short arrays are not equal should succeed`() {
        val arrayOne = shortArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 15)
        val arrayTwo = shortArrayOf(0, 5, 100, 121, 90, 76, 82, 55, 24, 14)

        arrayOne `contents should not be equal to` arrayTwo
    }
}
