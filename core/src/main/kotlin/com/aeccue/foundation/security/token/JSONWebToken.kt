package com.aeccue.foundation.security.token

import com.aeccue.foundation.json.ext.getOptional
import com.aeccue.foundation.text.ext.base64Decode
import com.aeccue.foundation.text.ext.base64Encode
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser

/**
 * An URL-safe token stored as JSON and used as a means to represent claims to be transferred
 * between two parties.
 *
 * @property [keyId] An optional id of the key used to encrypt or sign this token.
 */
abstract class JSONWebToken(private val keyId: String?) {

    companion object {

        /**
         * Separator of the header and payload in the token.
         */
        @JvmStatic
        protected val SEPARATOR = "."
    }

    /**
     * Token algorithms.
     */
    object Algorithms {

        const val NONE = "none"
        const val HMAC_256 = "HS256"
        const val HMAC_384 = "HS384"
        const val HMAC_512 = "HS512"
        const val RSA_PKCS1_256 = "RS256"
        const val RSA_PKCS1_384 = "RS384"
        const val RSA_PKCS1_512 = "RS512"
        const val RSA_PSS_256 = "PS256"
        const val RSA_PSS_384 = "PS384"
        const val RSA_PSS_512 = "PS512"
        const val ECDSA_256 = "ES256"
        const val ECDSA_384 = "ES384"
        const val ECDSA_512 = "ES512"
    }

    /**
     * Header parameters.
     */
    object Header {

        const val ALGORITHM = "alg"
        const val CONTENT_TYPE = "cty"
        const val CRITICAL = "crit"
        const val JWK_SET_URL = "jku"
        const val JSON_WEB_KEY = "jwk"
        const val KEY_ID = "kid"
        const val TYPE = "typ"
        const val X509_URL = "x5u"
        const val X509_CERT_CHAIN = "x5c"
        const val X509_CERT_SHA1_THUMBPRINT = "x5t"
        const val X509_CERT_SHA256_THUMBPRINT = "x5t#S256"
    }

    /**
     * Payload claims.
     */
    object Claim {
        const val AUDIENCE = "aud"
        const val EXPIRATION = "exp"
        const val ISSUED_AT = "iat"
        const val ISSUER = "iss"
        const val JWT_ID = "jti"
        const val NOT_BEFORE = "nbf"
        const val SUBJECT = "sub"
    }

    /**
     * JOSE header. Can only be set using the setter function.
     */
    var header: JSONObject = JSONObject().apply {
        if (keyId != null) put(Header.KEY_ID, keyId)
    }
        private set

    /**
     * Header encoded in Base64. Can only be set using the setter function.
     */
    var headerEncoded: String = header.toJSONString().base64Encode()
        private set

    /**
     * JSON payload holding the claims. Can only be set using the setter function.
     */
    var payload: JSONObject = JSONObject()
        private set

    /**
     * Payload encoded in Base64. Can only be set using the setter function.
     */
    var payloadEncoded: String = payload.toJSONString().base64Encode()
        private set

    /**
     * Gets the optional key id that was specified during the construction of this class.
     *
     * @return The key id, if it exists.
     */
    fun getKeyId(): String? = header.getOptional<String>(Header.KEY_ID)

    /**
     * Sets the header to this token, replacing the existing header. The Base64 encoded header will
     * also be updated.
     *
     * @param [header] The JOSE header.
     */
    open fun setHeader(header: JSONObject) {
        this.header = JSONObject(header)
        updateHeaderEncoded()
    }

    /**
     * Adds a header to the current header of this token. The Base64 encoded header will also be
     * updated.
     *
     * @param [key] The key of the header parameter.
     * @param [value] The value of the header parameter.
     */
    open fun addHeader(key: String, value: Any?) {
        header[key] = value
        updateHeaderEncoded()
    }

    /**
     * Removes a header from the current header of this token. The Base64 encoded header will also
     * be updated.
     *
     * @param [key] The key of the header parameter to remove.
     */
    open fun removeHeader(key: String) {
        header.remove(key)
        updateHeaderEncoded()
    }

    /**
     * Sets the Base64 encoded header of this token, replacing the existing header. The encoded
     * header will also be decoded and the resulting String will be parsed as a JSONObject and set
     * to the header of this token. If the header cannot be decoded or parsed as a JSONObject, an
     * exception is thrown.
     *
     * @param [headerEncoded] The Base64 encoded JOSE header.
     * @throws [IllegalArgumentException] If the header cannot be decoded or parsed as a JSONObject.
     */
    open fun setHeaderEncoded(headerEncoded: String) {
        headerEncoded.base64Decode()?.let {
            try {
                header = JSONParser().parse(it) as JSONObject
                this.headerEncoded = headerEncoded
            } catch (e: Exception) {
                throw java.lang.IllegalArgumentException(e)
            }
        } ?: throw IllegalArgumentException()
    }

    /**
     * Sets the payload to this token, replacing the existing payload. The Base64 encoded payload
     * will also be updated.
     *
     * @param [payload] The payload.
     */
    open fun setPayload(payload: JSONObject) {
        this.payload = JSONObject(payload)
        updatePayloadEncoded()
    }

    /**
     * Adds a claim to the current payload. The Base64 encoded payload will also be updated.
     *
     * @param [key] The key of the claim.
     * @param [value] The value of the claim.
     */
    open fun addClaim(key: String, value: Any?) {
        payload[key] = value
        updatePayloadEncoded()
    }

    /**
     * Removes a claim from the current payload. The Base64 encoded payload will also be updated.
     *
     * @param [key] The key of the claim to remove.
     */
    open fun removeClaim(key: String) {
        payload.remove(key)
        updatePayloadEncoded()
    }

    /**
     * Sets the Base64 encoded payload of this token, replacing the existing payload. The encoded
     * payload will also be decoded and the resulting String will be parsed as a JSONObject and set
     * to the payload of this token. If the payload cannot be decoded or parsed as a JSONObject, an
     * exception is thrown.
     *
     * @param [payloadEncoded] The Base64 encoded payload.
     * @throws [IllegalArgumentException] If the payload cannot be decoded or parsed as a JSONObject.
     */
    open fun setPayloadEncoded(payloadEncoded: String) {
        payloadEncoded.base64Decode()?.let {
            try {
                payload = JSONParser().parse(it) as JSONObject
                this.payloadEncoded = payloadEncoded
            } catch (e: Exception) {
                throw IllegalArgumentException(e)
            }
        } ?: throw IllegalArgumentException()
    }

    /**
     * Extracts the Base64 encoded header and payload from a token String and sets it to this token.
     *
     * @param [token] The token string.
     * @throws [IllegalArgumentException] If the token String is invalid.
     */
    open fun setToken(token: String) {
        val parts = token.split(SEPARATOR)
        if (parts.size != 2) throw IllegalArgumentException()

        setHeaderEncoded(parts[0])
        setPayloadEncoded(parts[1])
    }

    /**
     * Creates a String representing the Base64 encoded header and payload of this token.
     *
     * @return This token as a String.
     */
    open fun getToken(): String = "$headerEncoded$SEPARATOR$payloadEncoded"

    /**
     * Updates the Base64 encoded header with the current header.
     */
    private fun updateHeaderEncoded() {
        headerEncoded = header.toJSONString().base64Encode()
    }

    /**
     * Updates the Base64 encoded payload with the current payload.
     */
    private fun updatePayloadEncoded() {
        payloadEncoded = payload.toJSONString().base64Encode()
    }
}
