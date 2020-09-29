package com.aeccue.foundation.security.token

import com.aeccue.foundation.text.ext.base64Encode

/**
 * A [JSONWebToken] that is secured with a digital signature or Message Authentication Code.
 *
 * @param [keyId] An optional id of the key used to sign this token.
 */
abstract class JSONWebSignature(keyId: String?) : JSONWebToken(keyId) {

    /**
     * Extracts the Base64 encoded header and payload from a token String and sets it to this token.
     * The signature will first be verified and an exception is thrown if it does not match the header
     * and payload.
     *
     * @param [token] The token string.
     * @throws [IllegalArgumentException] If the token String is invalid, or the signature is not valid.
     */
    override fun setToken(token: String) {
        val parts = token.split(SEPARATOR)
        if (parts.size != 3) throw IllegalArgumentException()
        if (parts[2] != createSignature(parts[0], parts[1])) throw IllegalArgumentException()

        setHeaderEncoded(parts[0])
        setPayloadEncoded(parts[1])
    }

    /**
     * Creates a String representing the Base64 encoded header, payload and signature of this token.
     *
     * @return This token as a String.
     */
    override fun getToken(): String = "$headerEncoded$SEPARATOR$payloadEncoded$SEPARATOR${createSignature()}"

    /**
     * Signs the data.
     *
     * @param [data] The data to sign.
     * @return The signature of the data as a ByteArray.
     */
    protected abstract fun sign(data: String): ByteArray

    /**
     * Creates signatures with a header and payload, and encodes it to Base64.
     *
     * @param [header] The header to include in the signature. Defaults to [headerEncoded].
     * @param [payload] The payload to include in the signature. Defaults to [payloadEncoded].
     * @return The signature of the header and payload.
     */
    private fun createSignature(header: String = headerEncoded, payload: String = payloadEncoded)
            : String = sign("$header$SEPARATOR$payload").base64Encode()
}