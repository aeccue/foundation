package com.aeccue.foundation.json.token

import com.aeccue.foundation.test.*
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.json.simple.JSONObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JSONWebSignatureTest {

    @Test
    fun `setting key id should produce correct key id in header`() {
        val token = JSONWebSignatureImplementation("", TEST_STRING)
        token.header[JSONWebToken.Headers.KEY_ID] `should be equal to` TEST_STRING
        token.getKeyId() `should be equal to` TEST_STRING
    }

    @Test
    fun `setting an invalid token string should return false`() {
        val token = JSONWebSignatureImplementation("correct signature")
        val invalidTokenString = "only two.parts"
        token.setToken(invalidTokenString).`should be false`()
    }

    @Test
    fun `setting a token string with incorrect signature should return false`() {
        val token = JSONWebSignatureImplementation("correct signature")
        val invalidTokenString = "hello.world.incorrect signature"
        token.setToken(invalidTokenString).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting a valid token should set the header and payload correctly`(testCase: JSONWebSignatureTestCase) {
        val token = JSONWebSignatureImplementation(testCase.signature)
        token.setToken(testCase.tokenString).`should be true`()

        token.header `should be equal to` testCase.header
        token.payload `should be equal to` testCase.payload
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting header and payload in token should result in correct token string`(testCase: JSONWebSignatureTestCase) {
        val token = JSONWebSignatureImplementation(testCase.signature)
        token.header = testCase.header
        token.payload = testCase.payload

        token.getToken() `should be equal to` testCase.tokenString
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            JSONWebSignatureTestCase(
                    TEST_JSON,
                    TEST_JSON,
                    TEST_STRING,
                    "$TEST_JSON_BASE64_ENCODED.$TEST_JSON_BASE64_ENCODED.$TEST_STRING_BASE64_ENCODED"
            ),
            JSONWebSignatureTestCase(
                    JSONObject().apply { put("hello", "world") },
                    JSONObject().apply { put("goodbye", "world!") },
                    "signature",
                    "eyJoZWxsbyI6IndvcmxkIn0=.eyJnb29kYnllIjoid29ybGQhIn0=.c2lnbmF0dXJl"
            ),
            JSONWebSignatureTestCase(
                    JSONObject().apply { put("header", JSONObject().apply { put("innerjson", "inception") }) },
                    JSONObject().apply { put("payload", 12345678L) },
                    TEST_STRING_BASE64_ENCODED,
                    "eyJoZWFkZXIiOnsiaW5uZXJqc29uIjoiaW5jZXB0aW9uIn19.eyJwYXlsb2FkIjoxMjM0NTY3OH0=.U0dWc2JHOGdWMjl5YkdRaA=="
            )
    )
}

data class JSONWebSignatureTestCase(val header: JSONObject,
                                    val payload: JSONObject,
                                    val signature: String,
                                    val tokenString: String)

private class JSONWebSignatureImplementation(private val signature: String, key: String? = null) : JSONWebSignature(key) {

    override fun sign(data: String): ByteArray = signature.toByteArray()
}
