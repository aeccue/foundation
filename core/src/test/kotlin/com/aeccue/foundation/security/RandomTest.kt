package com.aeccue.foundation.security

import com.aeccue.foundation.test.TEST_CASES
import com.aeccue.foundation.test.ext.`contents should not be equal to`
import com.aeccue.foundation.text.validator.AlphaNumericStringValidator
import org.amshove.kluent.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RandomTest {

    @Test
    fun `generating ByteArray with size of 0 should throw exception`() {
        invoking { Random.generateByteArray(0) } `should throw` IllegalArgumentException::class
    }

    @Test
    fun `generating String with size of 0 should throw exception`() {
        invoking { Random.generateAlphanumericString(0) } `should throw` IllegalArgumentException::class
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `generating ByteArray with specific size should return ByteArray of that size`(size: Int) {
        Random.generateByteArray(size).size `should be equal to` size
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `generating random ByteArray multiple times should produce different ByteArrays`(size: Int) {
        val firstRandom = Random.generateByteArray(size)
        val secondRandom = Random.generateByteArray(size)

        firstRandom `contents should not be equal to` secondRandom
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `generating String with specific length should return String of that length`(length: Int) {
        Random.generateAlphanumericString(length).length `should be equal to` length
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `generating random String multiple times should produce different Strings`(length: Int) {
        val firstRandom = Random.generateAlphanumericString(length)
        val secondRandom = Random.generateAlphanumericString(length)

        println(firstRandom)
        println(secondRandom)

        firstRandom `should not be equal to` secondRandom
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `generating random alphanumeric String should produce valid alphanumeric String`(length: Int) {
        val random = Random.generateAlphanumericString(length)
        AlphaNumericStringValidator.validate(random).`should be true`()
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(1, 128, 256, 512)
}
