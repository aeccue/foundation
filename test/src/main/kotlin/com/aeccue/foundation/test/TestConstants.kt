package com.aeccue.foundation.test

import org.json.simple.JSONObject

const val TEST_CASES = "testCases"
const val TEST_STRING = "Hello World!"
const val TEST_STRING_BASE64_ENCODED = "SGVsbG8gV29ybGQh"

val TEST_STRING_SET = setOf("Hello", "World")

val TEST_JSON = JSONObject().apply {
    put("one", 1L)
    put("two", "2")
    put("three", null)
    put("four", true)
    put("five", 5.5)
}

val TEST_BYTE_ARRAY_12 = byteArrayOf(1, 12, 23, 34, 45, 56, 67, 78, 89, 98, 101, 112)
val TEST_BYTE_ARRAY_16 = byteArrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 111, 122, -122, -111, -101)
