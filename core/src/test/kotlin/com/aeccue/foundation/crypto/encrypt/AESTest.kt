package com.aeccue.foundation.crypto.encrypt

import com.aeccue.foundation.test.*
import com.aeccue.foundation.text.ext.base64DecodeToByteArray
import com.aeccue.foundation.text.ext.base64Encode
import com.aeccue.foundation.test.ext.`contents should be equal to`
import com.aeccue.foundation.test.ext.`contents should not be equal to`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AESTest {

    @Test
    fun `created key should have proper algorithm`() {
        val key = AES.createKey(TEST_BYTE_ARRAY_16)
        key.algorithm `should be equal to` "AES"
    }

    @Test
    fun `created key should have proper ByteArray`() {
        val key = AES.createKey(TEST_BYTE_ARRAY_16)
        key.encoded `contents should be equal to` TEST_BYTE_ARRAY_16
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `encrypted data should not have the same value as data`(testCase: AESTestCase) {
        val decodedKey = testCase.key.base64DecodeToByteArray() ?: fail("key is not Base64 encoded")
        val key = AES.createKey(decodedKey)
        val dataBytes = testCase.data.toByteArray()
        val encryptedData = AES.encrypt(key, dataBytes)
        encryptedData `contents should not be equal to` dataBytes
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `encrypted data should decrypt to the same data`(testCase: AESTestCase) {
        val decodedKey = testCase.key.base64DecodeToByteArray() ?: fail("key is not Base64 encoded")
        val key = AES.createKey(decodedKey)
        val dataBytes = testCase.data.toByteArray()
        val encryptedData = AES.encrypt(key, dataBytes)
        val decryptedData = AES.decrypt(key, encryptedData)
        decryptedData `contents should be equal to` dataBytes
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `encrypted data with IV should not have the same value as data`(testCase: AESTestCase) {
        val decodedKey = testCase.key.base64DecodeToByteArray() ?: fail("key is not Base64 encoded")
        val decodedIV = testCase.iv.base64DecodeToByteArray() ?: fail("iv is not Base64 encoded")
        val key = AES.createKey(decodedKey)
        val dataBytes = testCase.data.toByteArray()
        val encryptedData = AES.encrypt(key, decodedIV, dataBytes)
        encryptedData `contents should not be equal to` dataBytes
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `encrypted data with IV should decrypt to the same data`(testCase: AESTestCase) {
        val decodedKey = testCase.key.base64DecodeToByteArray() ?: fail("key is not Base64 encoded")
        val decodedIV = testCase.iv.base64DecodeToByteArray() ?: fail("iv is not Base64 encoded")
        val key = AES.createKey(decodedKey)
        val dataBytes = testCase.data.toByteArray()
        val encryptedData = AES.encrypt(key, decodedIV, dataBytes)
        val decryptedData = AES.decrypt(key, decodedIV, encryptedData)
        decryptedData `contents should be equal to` dataBytes
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            AESTestCase(TEST_STRING, TEST_BYTE_ARRAY_16.base64Encode(), TEST_BYTE_ARRAY_12.base64Encode()),
            AESTestCase("Test Data",
                    byteArrayOf(1, 12, 23, 34, 45, 56, 67, 78, 89, 98, 101, 112, 123, -121, -110, -99).base64Encode(),
                    byteArrayOf(0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 111).base64Encode()),
            AESTestCase("This will be encrypted and then decrypted",
                    byteArrayOf(5, 33, -21, 42, -52, 32, -100, 125, -123, 82, -83, 62, -75, 43, 22, 12).base64Encode(),
                    byteArrayOf(5, 33, -21, 42, -52, 32, -100, 125, -123, 82).base64Encode()),
            AESTestCase("     ",
                    byteArrayOf(-5, -22, 14, 123, 127, -127, 42, -42, -32, 53, 88, 92, 73, 29, 101, 111).base64Encode(),
                    byteArrayOf(11, 22, 33, 44, -11, -22, -33, -44).base64Encode())
    )
}

data class AESTestCase(val data: String, val key: String, val iv: String)
