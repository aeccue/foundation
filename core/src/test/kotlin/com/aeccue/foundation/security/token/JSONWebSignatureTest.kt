package com.aeccue.foundation.security.token

import com.aeccue.foundation.test.*
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.json.simple.JSONObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JSONWebSignatureTest {

    @Test
    fun `setting an invalid token string should throw an exception`() {
        val token = JSONWebSignatureImplementation("correct signature")
        val invalidTokenString = "only two.parts"
        invoking { token.setToken(invalidTokenString) } `should throw` IllegalArgumentException::class
    }

    @Test
    fun `setting a token string with incorrect signature should throw an exception`() {
        val token = JSONWebSignatureImplementation("correct signature")
        val invalidTokenString = "hello.world.incorrect signature"
        invoking { token.setToken(invalidTokenString) } `should throw` IllegalArgumentException::class
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting a valid token should set the header and payload correctly`(testCase: JSONWebSignatureTestCase) {
        val token = JSONWebSignatureImplementation(testCase.signature)
        token.setToken(testCase.tokenString)

        token.header `should be equal to` token.header
        token.payload `should be equal to` token.payload
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting header and payload in token should result in correct token string`(testCase: JSONWebSignatureTestCase) {
        val token = JSONWebSignatureImplementation(testCase.signature)
        token.setHeader(testCase.header)
        token.setPayload(testCase.payload)

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

private class JSONWebSignatureImplementation(private val signature: String) : JSONWebSignature(null) {

    override fun sign(data: String): ByteArray = signature.toByteArray()
}
