package com.aeccue.foundation.text.ext

import com.aeccue.foundation.text.StringLength
import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.test.TEST_STRING_BASE64_ENCODED
import com.aeccue.foundation.test.ext.`contents should be equal to`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

private const val INVALID_BASE64_STRING = "$TEST_STRING_BASE64_ENCODED~"

class Base64Test {

    @Test
    fun `converts String length to its Base64 encoded String length`() {
        StringLength(TEST_STRING.length).toBase64Length() `should be equal to` TEST_STRING_BASE64_ENCODED.length
    }

    @Test
    fun `encodes a String with Base64`() {
        TEST_STRING.base64Encode() `should be equal to` TEST_STRING_BASE64_ENCODED
    }

    @Test
    fun `encodes a ByteArray with Base64`() {
        TEST_STRING.toByteArray().base64Encode() `should be equal to` TEST_STRING_BASE64_ENCODED
    }

    @Test
    fun `decodes a Base64 encoded String`() {
        TEST_STRING_BASE64_ENCODED.base64Decode() `should be equal to` TEST_STRING
    }

    @Test
    fun `decodes an invalid Base64 String`() {
        INVALID_BASE64_STRING.base64Decode() `should be equal to` null
    }

    @Test
    fun `decodes a Base64 encoded ByteArray`() {
        TEST_STRING_BASE64_ENCODED.base64DecodeToByteArray() `contents should be equal to` TEST_STRING.toByteArray()
    }

    @Test
    fun `decodes an invalid Base64 ByteArray`() {
        INVALID_BASE64_STRING.base64DecodeToByteArray() `contents should be equal to` null
    }
}
