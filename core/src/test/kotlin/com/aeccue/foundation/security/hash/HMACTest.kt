package com.aeccue.foundation.security.hash

import com.aeccue.foundation.test.TEST_BYTE_ARRAY_16
import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.text.ext.base64DecodeToByteArray
import com.aeccue.foundation.text.ext.base64Encode
import com.aeccue.foundation.test.TEST_CASES
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should not be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HMACTest {

    @Test
    fun `created key should have proper algorithm`() {
        val key = HMAC.createKey(TEST_BYTE_ARRAY_16)
        key.algorithm `should be equal to` "HmacSHA256"
    }

    @Test
    fun `created key should have proper ByteArray`() {
        val key = HMAC.createKey(TEST_BYTE_ARRAY_16)
        key.encoded `should be equal to` TEST_BYTE_ARRAY_16
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `message hashed to should equal predetermined hash`(testCase: HMACTestCase) {
        val key = HMAC.createKey(testCase.key.toByteArray())
        val actualHash = HMAC.hash(key, testCase.message.toByteArray())
        val expectedHash = testCase.hash.base64DecodeToByteArray()
                ?: fail("expected hash is not Base64 encoded")
        actualHash `should be equal to` expectedHash
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `changing message and hashing it should not equal predetermined hash`(testCase: HMACTestCase) {
        val key = HMAC.createKey(testCase.key.toByteArray())
        val actualHash = HMAC.hash(key, "${testCase.message}!".toByteArray())
        val notExpectedHash = testCase.hash.base64DecodeToByteArray()
                ?: fail("expected hash is not Base64 encoded")
        actualHash `should not be equal to` notExpectedHash
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            HMACTestCase(TEST_STRING, TEST_BYTE_ARRAY_16.base64Encode(), "teEXsyyAjazqgyCbtyWI7zELDg2Ep0yQ+0MP1R+dmz4="),
            HMACTestCase("This is a test String", "test key", "UCMS3QFwVWuEifGpRJDpqH5Sfaew33ZdcxSDo6DLQJQ="),
            HMACTestCase("This String will be hashed", "another test key", "T2jM3Vg/cffoKY0hA3/M4qHWWuRhSdgHI77K8C0svV0="),
            HMACTestCase("     ", "adoiwajdoaiwjd1231231o", "RwqOj2Sg/SFGjeh5J3KBpK40az3Sc6tHeC8g2s9ge6I=")
    )
}

data class HMACTestCase(val message: String, val key: String, val hash: String)
