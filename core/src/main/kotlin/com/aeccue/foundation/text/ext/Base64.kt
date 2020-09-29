package com.aeccue.foundation.text.ext

import com.aeccue.foundation.text.StringLength
import java.util.Base64.getDecoder
import java.util.Base64.getEncoder

/**
 * Converts this String length to the length of its Base64 encoded String.
 *
 * @return The length of the Base64 encoded String.
 */
fun StringLength.toBase64Length(): Int = 4 * ((this.length + 2) / 3)

/**
 * Encodes this ByteArray into a Base64 String.
 *
 * @return The Base64 encoded String.
 */
fun ByteArray.base64Encode(): String = getEncoder().encodeToString(this)

/**
 * Encodes this String into a Base64 String.
 *
 * @return The Base64 encoded String
 */
fun String.base64Encode(): String = toByteArray().base64Encode()

/**
 * Attempts to decode this String as a Base64 encoded String into its original String.
 *
 * @return The decoded String or null if the source cannot be decoded.
 */
fun String.base64Decode(): String? = base64DecodeToByteArray()?.let { String(it) }

/**
 * Attempts to decode this String as a Base64 encoded String into its original ByteArray.
 *
 * @return The decoded ByteArray or null if the source cannot be decoded.
 */
fun String.base64DecodeToByteArray(): ByteArray? =
        try {
            getDecoder().decode(this)
        } catch (e: Exception) {
            null
        }
