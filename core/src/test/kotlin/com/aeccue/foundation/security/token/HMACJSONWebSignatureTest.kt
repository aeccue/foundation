package com.aeccue.foundation.security.token

import com.aeccue.foundation.security.hash.HMAC
import com.aeccue.foundation.test.*
import com.aeccue.foundation.text.ext.base64Encode
import org.amshove.kluent.`should be equal to`
import org.json.simple.JSONObject
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HMACJSONWebSignatureTest {

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `creating an HMACJSONWebSignature should produce a token with a proper signature`(testCase: HMACJSONWebSignatureTestCase) {
        val key = HMAC.createKey(testCase.key.toByteArray())
        val token = HMACJSONWebSignature(key).apply {
            header = testCase.header
            payload = testCase.payload
        }
        token.getToken() `should be equal to` testCase.expectedTokenString
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            HMACJSONWebSignatureTestCase(
                    TEST_BYTE_ARRAY_16.base64Encode(),
                    TEST_JSON,
                    TEST_JSON,
                    "$TEST_JSON_BASE64_ENCODED.$TEST_JSON_BASE64_ENCODED.NHtk84KbVw/SNgD8AII/IIdQckY21hkhhWQEB2FApwQ="
            ),
            HMACJSONWebSignatureTestCase(
                    TEST_STRING,
                    JSONObject().apply { put("hello", "world") },
                    JSONObject().apply { put("goodbye", "world!") },
                    "eyJoZWxsbyI6IndvcmxkIn0=.eyJnb29kYnllIjoid29ybGQhIn0=.Ea/kpX5XGMCfKR5mVThPWNOA+C9/ibwwL2PxChKWoeU="
            ),
            HMACJSONWebSignatureTestCase(
                    TEST_STRING_BASE64_ENCODED,
                    JSONObject().apply { put("header", JSONObject().apply { put("innerjson", "inception") }) },
                    JSONObject().apply { put("payload", 12345678L) },
                    "eyJoZWFkZXIiOnsiaW5uZXJqc29uIjoiaW5jZXB0aW9uIn19.eyJwYXlsb2FkIjoxMjM0NTY3OH0=.zVIe/AA3JxwVDBUUhtfz/f8NuZ276BlZ/sjwPGtz2Ks="
            )
    )
}

data class HMACJSONWebSignatureTestCase(val key: String,
                                        val header: JSONObject,
                                        val payload: JSONObject,
                                        val expectedTokenString: String)
