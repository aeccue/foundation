package com.aeccue.foundation.security.token

import com.aeccue.foundation.security.hash.HMAC
import javax.crypto.SecretKey

/**
 * A [JSONWebSignature] that is signed with HMAC SHA256.
 *
 * @param [key] The key used to sign this token.
 * @param [keyId] An optional id of the key used to sign this token.
 */
open class HMACJSONWebSignature(private val key: SecretKey, keyId: String? = null) : JSONWebSignature(keyId) {

    /**
     * Signs the data with HMAC SHA256.
     *
     * @param [data] The data to sign.
     * @return The signature of the data as a ByteArray.
     */
    override fun sign(data: String): ByteArray = HMAC.hash(key, data.toByteArray())
}
