package com.aeccue.foundation.security.token

import com.aeccue.foundation.test.TEST_CASES
import com.aeccue.foundation.test.TEST_JSON
import com.aeccue.foundation.test.TEST_JSON_BASE64_ENCODED
import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.test.ext.toClock
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JSONWebTokenTest {

    private val clock = 1000000L.toClock()

    @Test
    fun `setting key id should produce correct key id in header`() {
        val token = JSONWebTokenImplementation(TEST_STRING)
        token.header[JSONWebToken.Headers.KEY_ID] `should be equal to` TEST_STRING
        token.getKeyId() `should be equal to` TEST_STRING
    }

    @Test
    fun `adding header should result in correct header`() {
        val expectedHeader = TEST_JSON
        val token = JSONWebTokenImplementation().apply {
            for (h in expectedHeader) {
                header.containsKey(h.key).`should be false`()
                addHeader(h.key as String, h.value)
                header.containsKey(h.key).`should be true`()
            }
        }

        token.header `should be equal to` expectedHeader
    }

    @Test
    fun `removing header should result in correct header`() {
        val header = TEST_JSON
        val token = JSONWebTokenImplementation().apply {
            this.header = header
            for (h in header) {
                this.header.containsKey(h.key).`should be true`()
                removeHeader(h.key as String)
                this.header.containsKey(h.key).`should be false`()
            }
        }

        val expectedHeader = JSONObject()
        token.header `should be equal to` expectedHeader
    }

    @Test
    fun `adding claim should result in correct payload`() {
        val expectedPayload = TEST_JSON
        val token = JSONWebTokenImplementation().apply {
            for (claim in expectedPayload) {
                payload.containsKey(claim.key).`should be false`()
                addClaim(claim.key as String, claim.value)
                payload.containsKey(claim.key).`should be true`()
            }
        }

        token.payload `should be equal to` expectedPayload
    }

    @Test
    fun `removing claim should result in correct payload`() {
        val payload = TEST_JSON
        val token = JSONWebTokenImplementation().apply {
            this.payload = payload
            for (claim in payload) {
                this.payload.containsKey(claim.key).`should be true`()
                removeClaim(claim.key as String)
                this.payload.containsKey(claim.key).`should be false`()
            }
        }

        val expectedPayload = JSONObject()
        token.payload `should be equal to` expectedPayload
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting token string should result in correct header and payload`(testCase: JSONWebTokenTestCase) {
        val token = JSONWebTokenImplementation(TEST_STRING).apply {
            setToken(testCase.tokenString)
        }

        token.header `should be equal to` testCase.header
        token.payload `should be equal to` testCase.payload
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `setting header and payload should create valid token string`(testCase: JSONWebTokenTestCase) {
        val token = JSONWebTokenImplementation(TEST_STRING).apply {
            header = testCase.header
            payload = testCase.payload
        }

        token.getToken() `should be equal to` testCase.tokenString
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            JSONWebTokenTestCase(
                    JSONObject().apply {
                        put(JSONWebToken.Headers.ALGORITHM, "algorithm")
                        put(JSONWebToken.Headers.CONTENT_TYPE, "content type")
                        put(JSONWebToken.Headers.CRITICAL, JSONArray().apply { add("kid") })
                        put(JSONWebToken.Headers.JWK_SET_URL, "url")
                        put(JSONWebToken.Headers.JSON_WEB_KEY, "web key")
                        put(JSONWebToken.Headers.TYPE, "type")
                        put(JSONWebToken.Headers.X509_URL, "url")
                        put(JSONWebToken.Headers.X509_CERT_CHAIN, "chain")
                        put(JSONWebToken.Headers.X509_CERT_SHA1_THUMBPRINT, "SHA1")
                        put(JSONWebToken.Headers.X509_CERT_SHA256_THUMBPRINT, "SHA256")
                    },
                    JSONObject().apply {
                        put(JSONWebToken.Claims.AUDIENCE, "test")
                        put(JSONWebToken.Claims.EXPIRATION, clock.millis())
                        put(JSONWebToken.Claims.ISSUED_AT, clock.millis())
                        put(JSONWebToken.Claims.ISSUER, "me")
                        put(JSONWebToken.Claims.JWT_ID, "test key id")
                        put(JSONWebToken.Claims.NOT_BEFORE, clock.millis())
                        put(JSONWebToken.Claims.SUBJECT, "test")
                    },
                    "eyJ4NXQjUzI1NiI6IlNIQTI1NiIsImNyaXQiOlsia2lkIl0sImprdSI6InVybCIsIng1dCI6IlNIQTEiLCJ4NWMiOiJjaGFpbiIsImN0eSI6ImNvbnRlbnQgdHlwZSIsIng1dSI6InVybCIsInR5cCI6InR5cGUiLCJhbGciOiJhbGdvcml0aG0iLCJqd2siOiJ3ZWIga2V5In0=.eyJhdWQiOiJ0ZXN0Iiwic3ViIjoidGVzdCIsIm5iZiI6MTAwMDAwMCwiaXNzIjoibWUiLCJleHAiOjEwMDAwMDAsImlhdCI6MTAwMDAwMCwianRpIjoidGVzdCBrZXkgaWQifQ=="
            ),
            JSONWebTokenTestCase(
                    TEST_JSON,
                    TEST_JSON,
                    "$TEST_JSON_BASE64_ENCODED.$TEST_JSON_BASE64_ENCODED"
            ),
            JSONWebTokenTestCase(
                    JSONObject().apply { put("hello", "world") },
                    JSONObject().apply { put("goodbye", "world!") },
                    "eyJoZWxsbyI6IndvcmxkIn0=.eyJnb29kYnllIjoid29ybGQhIn0="
            ),
            JSONWebTokenTestCase(
                    JSONObject().apply { put("header", JSONObject().apply { put("innerjson", "inception") }) },
                    JSONObject().apply { put("payload", 12345678L) },
                    "eyJoZWFkZXIiOnsiaW5uZXJqc29uIjoiaW5jZXB0aW9uIn19.eyJwYXlsb2FkIjoxMjM0NTY3OH0="
            )
    )
}

data class JSONWebTokenTestCase(val header: JSONObject, val payload: JSONObject, val tokenString: String)

private class JSONWebTokenImplementation(keyId: String? = null) : JSONWebToken(keyId)
