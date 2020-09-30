package com.aeccue.foundation.util

import com.aeccue.foundation.text.ext.ALPHANUMERIC
import java.security.SecureRandom

/**
 * Provides helper functions to generate cryptographically secure random values.
 */
object Random {

    private val instance: SecureRandom by lazy { SecureRandom.getInstanceStrong() }

    /**
     * Generates a ByteArray with cryptographically secure random bytes. Length must be greater than
     * 0.
     *
     * @param [size] The size of the ByteArray to generate.
     * @return A cryptographically secure random ByteArray.
     * @throws [IllegalArgumentException] If size is 0 or lower.
     */
    fun generateByteArray(size: Int): ByteArray {
        if (size < 1) throw IllegalArgumentException()
        return ByteArray(size).apply {
            instance.nextBytes(this)
        }
    }

    /**
     * Generates a cryptographically secure random alphanumeric String. Length must be greater than
     * 0.
     *
     * @param [length] The length of the String to generate.
     * @return A cryptographically secure random String.
     * @throws [IllegalArgumentException] If length is 0 or lower.
     */
    fun generateAlphanumericString(length: Int): String {
        if (length < 1) throw IllegalArgumentException()
        return String(CharArray(length).apply {
            for (i in 0 until length) {
                this[i] = String.ALPHANUMERIC[instance.nextInt(String.ALPHANUMERIC.length)]
            }
        })
    }
}
