package com.aeccue.foundation.io.ext

import com.aeccue.foundation.test.TEST_CASES
import com.aeccue.foundation.test.TEST_JSON
import org.amshove.kluent.`should be equal to`
import org.json.simple.JSONObject
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.StringReader
import java.util.stream.Stream

class ReaderTest {

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `reading a JSONObject from a JSON String should produce correct JSONObject`(testCase: JSONObject) {
        val reader = StringReader(testCase.toJSONString())
        val actualJSON = reader.readJSONObject()
        actualJSON `should be equal to` testCase
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            TEST_JSON,
            JSONObject().apply {
                put("hello", null)
                put("world", 5L)
                put("!", true)
                put("bye", 9.3)
            })
}
