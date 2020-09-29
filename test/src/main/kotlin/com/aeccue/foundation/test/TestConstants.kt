package com.aeccue.foundation.test

import org.json.simple.JSONArray
import org.json.simple.JSONObject

/**
 * Generally used for ParameterizedTests where a MethodSource is specified.
 */
const val TEST_CASES = "testCases"

/**
 * A sample String.
 */
const val TEST_STRING = "Hello World!"

/**
 * [TEST_STRING] encoded with Bsase64.
 */
const val TEST_STRING_BASE64_ENCODED = "SGVsbG8gV29ybGQh"

/**
 * A sample set of Strings.
 */
val TEST_STRING_SET = setOf("Hello", "World")

/**
 * A sample JSONObject with all possible types.
 */
val TEST_JSON = JSONObject().apply {
    put("one", 1L)
    put("two", "2")
    put("three", null)
    put("four", true)
    put("five", 5.5)
    put("six", JSONObject().apply { put("hello", "world") })
    put("seven", JSONArray().apply { addAll(TEST_STRING_SET) })
}

/**
 * A sample ByteArray of 12 elements.
 */
val TEST_BYTE_ARRAY_12 = byteArrayOf(1, 12, 23, 34, 45, 56, 67, 78, 89, 98, 101, 112)

/**
 * A sample ByteArray of 16 elements.
 */
val TEST_BYTE_ARRAY_16 = byteArrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 111, 122, -122, -111, -101)
