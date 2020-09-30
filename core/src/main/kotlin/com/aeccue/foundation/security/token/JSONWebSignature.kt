package com.aeccue.foundation.security.token

import com.aeccue.foundation.json.ext.getOptional
import com.aeccue.foundation.text.ext.base64DecodeToJSONObject
import com.aeccue.foundation.text.ext.base64Encode

/**
 * A [JSONWebToken] that is secured with a digital signature or Message Authentication Code.
 *
 * @param [keyId] An optional id of the key used to sign this token.
 */
abstract class JSONWebSignature(private val keyId: String?) : JSONWebToken() {

    init {
        if (keyId != null) {
            header[Headers.KEY_ID] = keyId
        }
    }

    /**
     * Extracts the Base64 encoded header and payload from a token String and sets it to this token.
     * The signature will first be verified and an exception is thrown if it does not match the header
     * and payload.
     *
     * @param [token] The token string.
     * @return True if the token String and signature are valid, false otherwise.
     */
    override fun setToken(token: String): Boolean {
        val parts = token.split(SEPARATOR)
        if (parts.size != 3) return false
        if (parts[2] != createSignature(parts[0], parts[1])) return false

        val header = parts[0].base64DecodeToJSONObject() ?: return false
        val payload = parts[1].base64DecodeToJSONObject() ?: return false

        this.header = header
        this.payload = payload

        return true
    }

    /**
     * Creates a String representing the Base64 encoded header, payload and signature of this token.
     *
     * @return This token as a String.
     */
    override fun getToken(): String {
        val encodedHeader = header.base64Encode()
        val encodedPayload = payload.base64Encode()
        val signature = createSignature(encodedHeader, encodedPayload)
        return "$encodedHeader$SEPARATOR$encodedPayload$SEPARATOR$signature"
    }

    /**
     * Gets the optional key id that was specified during the construction of this class.
     *
     * @return The key id, if it exists.
     */
    fun getKeyId(): String? = header.getOptional(Headers.KEY_ID)

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
     * @param [header] The header to include in the signature.
     * @param [payload] The payload to include in the signature.
     * @return The signature of the header and payload.
     */
    private fun createSignature(header: String, payload: String)
            : String = sign("$header$SEPARATOR$payload").base64Encode()
}
