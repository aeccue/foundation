package com.aeccue.foundation.collection.ext

import com.aeccue.foundation.test.TEST_STRING_SET
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

private const val SUCCESS_STRING_SET_TEST_CASES = "successStringSetTestCases"
private const val FAIL_STRING_SET_TEST_CASES = "failStringSetTestCases"

class SetExtensionsTest {

    @ParameterizedTest
    @MethodSource(SUCCESS_STRING_SET_TEST_CASES)
    fun `set contains element when case is ignored`(testCase: StringSetTestCase) {
        testCase.set.containsIgnoreCase(testCase.contains).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(FAIL_STRING_SET_TEST_CASES)
    fun `set does not contain element even when case is ignored`(testCase: StringSetTestCase) {
        testCase.set.containsIgnoreCase(testCase.contains).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(SUCCESS_STRING_SET_TEST_CASES)
    fun `all Strings in set should be in lower case`(testCase: StringSetTestCase) {
        val actualSet = testCase.set.toLowerCase()
        actualSet `should be equal to` testCase.lowerCaseSet
    }

    @Suppress("unused")
    private fun successStringSetTestCases() = Stream.of(
            StringSetTestCase(TEST_STRING_SET, "wOrlD", setOf("hello", "world")),
            StringSetTestCase(setOf("this", "IS", "a", "tesT!"), "TEst!", setOf("this", "is", "a", "test!"))
    )

    @Suppress("unused")
    private fun failStringSetTestCases() = Stream.of(
            StringSetTestCase(TEST_STRING_SET, "wOrl"),
            StringSetTestCase(setOf("this", "IS", "a", "tesT!"), "tesT")
    )
}

data class StringSetTestCase(val set: Set<String>, val contains: String, val lowerCaseSet: Set<String>? = null)
