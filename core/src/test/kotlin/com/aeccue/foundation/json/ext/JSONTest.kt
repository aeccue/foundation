package com.aeccue.foundation.json.ext

import com.aeccue.foundation.primitive.INVALID_VALUE
import com.aeccue.foundation.test.TEST_JSON
import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.test.TEST_STRING_SET
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.junit.jupiter.api.Test

class JSONTest {

    @Test
    fun `get or throw should return correct values`() {
        TEST_JSON.getOrThrow<Long>("one") `should be equal to` 1L
        TEST_JSON.getOrThrow<String>("two") `should be equal to` "2"
        TEST_JSON.getOrThrow<Boolean>("four") `should be equal to` true
        TEST_JSON.getOrThrow<Double>("five") `should be equal to` 5.5
        TEST_JSON.getOrThrow<JSONObject>("six") `should be equal to` JSONObject().apply { put("hello", "world") }
        TEST_JSON.getOrThrow<JSONArray>("seven") `should be equal to` JSONArray().apply { addAll(TEST_STRING_SET) }
    }

    @Test
    fun `get or throw with wrong type should throw exception`() {
        invoking { TEST_JSON.getOrThrow<String>("one") } `should throw` NoSuchElementException::class
    }

    @Test
    fun `get or throw on key with null value should throw exception`() {
        invoking { TEST_JSON.getOrThrow<String>("three") } `should throw` NoSuchElementException::class
    }

    @Test
    fun `get or throw on invalid key should throw exception`() {
        invoking { TEST_JSON.getOrThrow<String>("invalid key") } `should throw` NoSuchElementException::class
    }

    @Test
    fun `get or throw optional should return correct value`() {
        TEST_JSON.getOrThrowNullable<Long>("one") `should be equal to` 1L
        TEST_JSON.getOrThrowNullable<String>("two") `should be equal to` "2"
        TEST_JSON.getOrThrowNullable<String>("three") `should be equal to` null
        TEST_JSON.getOrThrowNullable<Boolean>("four") `should be equal to` true
        TEST_JSON.getOrThrowNullable<Double>("five") `should be equal to` 5.5
        TEST_JSON.getOrThrowNullable<JSONObject>("six") `should be equal to` JSONObject().apply { put("hello", "world") }
        TEST_JSON.getOrThrowNullable<JSONArray>("seven") `should be equal to` JSONArray().apply { addAll(TEST_STRING_SET) }
    }

    @Test
    fun `get should return correct value`() {
        TEST_JSON.get("one", Long.INVALID_VALUE) `should be equal to` 1L
        TEST_JSON.get("two", TEST_STRING) `should be equal to` "2"
        TEST_JSON.get("four", false) `should be equal to` true
        TEST_JSON.get("five", Double.INVALID_VALUE) `should be equal to` 5.5
        TEST_JSON.get("six", JSONObject()) `should be equal to` JSONObject().apply { put("hello", "world") }
        TEST_JSON.get("seven", JSONArray()) `should be equal to` JSONArray().apply { addAll(TEST_STRING_SET) }
    }

    @Test
    fun `get with wrong type should return default value`() {
        TEST_JSON.get("one", Double.INVALID_VALUE) `should be equal to` Double.INVALID_VALUE
        TEST_JSON.get("two", false) `should be equal to` false
        TEST_JSON.get("three", TEST_STRING) `should be equal to` TEST_STRING
        TEST_JSON.get("four", Long.INVALID_VALUE) `should be equal to` Long.INVALID_VALUE
        TEST_JSON.get("five", Int.INVALID_VALUE) `should be equal to` Int.INVALID_VALUE
        TEST_JSON.get("six", JSONArray()) `should be equal to` JSONArray()
        TEST_JSON.get("seven", JSONObject()) `should be equal to` JSONObject()
    }

    @Test
    fun `get with invalid key should return default value`() {
        TEST_JSON.get("invalid key", TEST_STRING) `should be equal to` TEST_STRING
    }

    @Test
    fun `get optional should return correct value`() {
        TEST_JSON.getOptional<Long>("one") `should be equal to` 1L
        TEST_JSON.getOptional<String>("two") `should be equal to` "2"
        TEST_JSON.getOptional<String>("three") `should be equal to` null
        TEST_JSON.getOptional<Boolean>("four") `should be equal to` true
        TEST_JSON.getOptional<Double>("five") `should be equal to` 5.5
        TEST_JSON.getOptional<JSONObject>("six") `should be equal to` JSONObject().apply { put("hello", "world") }
        TEST_JSON.getOptional<JSONArray>("seven") `should be equal to` JSONArray().apply { addAll(TEST_STRING_SET) }
    }

    @Test
    fun `get optional with wrong type should return default value`() {
        TEST_JSON.getOptional("one", Double.INVALID_VALUE) `should be equal to` Double.INVALID_VALUE
        TEST_JSON.getOptional("two", false) `should be equal to` false
        TEST_JSON.getOptional("three", TEST_STRING) `should be equal to` TEST_STRING
        TEST_JSON.getOptional("four", Long.INVALID_VALUE) `should be equal to` Long.INVALID_VALUE
        TEST_JSON.getOptional("five", Int.INVALID_VALUE) `should be equal to` Int.INVALID_VALUE
        TEST_JSON.getOptional("six", JSONArray()) `should be equal to` JSONArray()
        TEST_JSON.getOptional("seven", JSONObject()) `should be equal to` JSONObject()
    }

    @Test
    fun `get optional with wrong type and no default should return null`() {
        TEST_JSON.getOptional<Double>("one") `should be equal to` null
        TEST_JSON.getOptional<Boolean>("two") `should be equal to` null
        TEST_JSON.getOptional<String>("three") `should be equal to` null
        TEST_JSON.getOptional<Long>("four") `should be equal to` null
        TEST_JSON.getOptional<Int>("five") `should be equal to` null
        TEST_JSON.getOptional<JSONArray>("six") `should be equal to` null
        TEST_JSON.getOptional<JSONObject>("seven") `should be equal to` null
    }

    @Test
    fun `get optional with invalid key should return default value`() {
        TEST_JSON.getOptional("invalid key", TEST_STRING) `should be equal to` TEST_STRING
    }

    @Test
    fun `get optional with invalid key and no default should return null`() {
        TEST_JSON.getOptional<String>("invalid key") `should be equal to` null
    }

    @Test
    fun `get nullable on value that is null should return null`() {
        TEST_JSON.getNullable<String>("three") `should be equal to` null
    }
}
