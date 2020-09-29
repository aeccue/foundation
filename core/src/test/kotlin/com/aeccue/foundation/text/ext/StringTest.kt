package com.aeccue.foundation.text.ext

import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.text.validator.StringValidator
import org.amshove.kluent.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringExtensionsTest {

    private val trueStringValidator = object : StringValidator {
        override fun validate(value: String) = true
    }

    private val falseStringValidator = object : StringValidator {
        override fun validate(value: String) = false
    }

    @ParameterizedTest
    @MethodSource("successTestCases")
    fun `validate valid String`(testCase: StringValidateTestCase) {
        with(testCase) {
            target.validate(maxLength, minLength, nullable, validator).`should be true`()
        }
    }

    @ParameterizedTest
    @MethodSource("failTestCases")
    fun `validate invalid String`(testCase: StringValidateTestCase) {
        with(testCase) {
            target.validate(maxLength, minLength, nullable, validator).`should be false`()
        }
    }

    @Test
    fun `validating String with max length less than min length should throw Exception`() {
        invoking { TEST_STRING.validate(1, 2) } `should throw` IllegalArgumentException::class
    }

    @Test
    fun `validating String with negative min length should throw Exception`() {
        invoking { TEST_STRING.validate(1, -1) } `should throw` IllegalArgumentException::class
    }

    @Test
    fun `replace all continuous whitespace characters with one whitespace`() {
        val stringWithSpaces = "Hello\t   \n   World!"
        val expectedString = "Hello World!"
        stringWithSpaces.normalizeSpace() `should be equal to` expectedString
    }

    @Suppress("unused")
    private fun successTestCases() = Stream.of(
            StringValidateTestCase(TEST_STRING, 12, 11, false, trueStringValidator),
            StringValidateTestCase("", 1, 0, false, trueStringValidator),
            StringValidateTestCase(null, 1, 0, true, trueStringValidator)
    )

    @Suppress("unused")
    private fun failTestCases() = Stream.of(
            StringValidateTestCase(TEST_STRING, 11, 0, true, trueStringValidator),
            StringValidateTestCase(TEST_STRING, 13, 13, true, trueStringValidator),
            StringValidateTestCase(TEST_STRING, 12, 0, false, falseStringValidator),
            StringValidateTestCase(" ", 1, 1, true, trueStringValidator),
            StringValidateTestCase(null, 1, 0, false, trueStringValidator)
    )
}

data class StringValidateTestCase(val target: String?,
                                  val maxLength: Int,
                                  val minLength: Int,
                                  val nullable: Boolean,
                                  val validator: StringValidator?)
