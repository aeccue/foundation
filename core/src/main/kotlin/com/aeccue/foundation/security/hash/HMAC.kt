package com.aeccue.foundation.security.hash

import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

private const val ALGORITHM = "HmacSHA256"

/**
 * Hashes messages with the HMAC SHA256 algorithm.
 */
object HMAC {

    /**
     * HMAC instance.
     */
    private val hmac: Mac by lazy { Mac.getInstance(ALGORITHM) }

    /**
     * Creates a SecretKey for HMAC SHA256.
     *
     * @param [key] The key to create the SecretKey from.
     * @return The secret key for hashing.
     */
    fun createKey(key: ByteArray): SecretKey = SecretKeySpec(key, ALGORITHM)

    /**
     * Hashes a message with a secret key using HMAC SHA256.
     *
     * @param [key] The secret key for hashing.
     * @param [message] The message to hash.
     * @return The hashed message.
     */
    fun hash(key: SecretKey, message: ByteArray): ByteArray {
        hmac.init(key)
        return hmac.doFinal(message)
    }
}
