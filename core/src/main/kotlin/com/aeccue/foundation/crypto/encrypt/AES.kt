package com.aeccue.foundation.crypto.encrypt

import com.aeccue.foundation.util.Random
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

private const val ALGORITHM_KEY = "AES"
private const val ALGORITHM_CIPHER = "AES/GCM/NoPadding"

private const val LENGTH_IV = 16
private const val LENGTH_TAG = 128

/**
 * Encrypts and decrypts data with AES.
 */
object AES {

    private val instance: Cipher by lazy { Cipher.getInstance(ALGORITHM_CIPHER) }

    /**
     * Creates a SecretKey for AES.
     *
     * @param [key] The key to create the SecretKey from.
     * @return The secret key for encrypting.
     */
    fun createKey(key: ByteArray): SecretKey = SecretKeySpec(key, ALGORITHM_KEY)

    /**
     * Encrypts data with a secret key and initialization vector.
     *
     * @param [key] The secret key for encrypting.
     * @param [iv] The initialization vector to use while encrypting.
     * @param [data] The data to encrypt.
     * @return The encrypted data.
     */
    fun encrypt(key: SecretKey, iv: ByteArray, data: ByteArray): ByteArray {
        val params = GCMParameterSpec(LENGTH_TAG, iv)
        instance.init(Cipher.ENCRYPT_MODE, key, params)
        return instance.doFinal(data)
    }

    /**
     * Encrypts data with a secret key and a randomly generated initialization vector bytes. The
     * initialization vector is then prepended to the encrypted data in the following format:
     * Result = iv + encrypted data
     *
     * @param [key] The secret key for encrypting.
     * @param [data] The data to encrypt.
     * @param [ivLength] The length of the initialization vector to generate. Defaults to [LENGTH_IV].
     * @return The encrypted data with the initialization vector prepended to it.
     */
    fun encrypt(key: SecretKey, data: ByteArray, ivLength: Int = LENGTH_IV): ByteArray {
        val iv = Random.generateByteArray(ivLength)
        return iv + encrypt(key, iv, data)
    }

    /**
     * Decrypts encrypted data using a secret key and initialization vector.
     *
     * @param [key] The secret key for decrypting.
     * @param [iv] The initialization vector used to encrypt the data.
     * @param [encryptedData] The encrypted data to decrypt.
     * @return The decrypted data, or null if data cannot be decrypted.
     */
    fun decrypt(key: SecretKey, iv: ByteArray, encryptedData: ByteArray): ByteArray? {
        val params = GCMParameterSpec(LENGTH_TAG, iv)
        instance.init(Cipher.DECRYPT_MODE, key, params)
        return try {
            instance.doFinal(encryptedData)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Decrypts encrypted data using a secret key. The initialization vector will be extracted from
     * the start of the encrypted data and used for decrypting.
     *
     * @param [key] The secret key for decrypting.
     * @param [encryptedData] The initialization vector and the encrypted data to decrypt.
     * @param [ivLength] The length of the initialization vector to extract. Defaults to [LENGTH_IV].
     * @return The decrypted data, or null if data cannot be decrypted.
     */
    fun decrypt(key: SecretKey, encryptedData: ByteArray, ivLength: Int = LENGTH_IV): ByteArray? {
        val params = GCMParameterSpec(LENGTH_TAG, encryptedData, 0, ivLength)
        instance.init(Cipher.DECRYPT_MODE, key, params)
        return try {
            instance.doFinal(encryptedData, ivLength, encryptedData.size - ivLength)
        } catch (e: Exception) {
            null
        }
    }
}
