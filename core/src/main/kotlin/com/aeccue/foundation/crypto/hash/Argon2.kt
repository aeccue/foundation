package com.aeccue.foundation.crypto.hash

import de.mkammerer.argon2.Argon2
import de.mkammerer.argon2.Argon2Factory

private const val HASH_ITERATIONS = 2
private const val HASH_MEMORY = 65536
private const val HASH_PARALLELISM = 2

/**
 * Hashes passwords using Argon2 key derivation function and verify Argon2 hashes.
 */
object Argon2 {

    private val instance: Argon2 by lazy { Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id) }

    /**
     * Hashes a password with Argon2id.
     *
     * Default Configurations
     * - iterations: 2
     * - memory: 65536
     * - parallelism: 2
     *
     * @param [password] The password to hash.
     * @param [iterations] The number of iterations to hash the password. Defaults to 2.
     * @param [memory] The amount of memory to use in kilobytes. Defaults to 65536.
     * @param [parallelism] The number of threads and compute lanes to use. Defaults to 2.
     * @return The hash of the password.
     */
    fun hash(password: String,
             iterations: Int = HASH_ITERATIONS,
             memory: Int = HASH_MEMORY,
             parallelism: Int = HASH_PARALLELISM): String =
            instance.hash(iterations, memory, parallelism, password.toCharArray())

    /**
     * Verifies a password against a hash.
     *
     * @param [hash] The hash to verify.
     * @param [password] The password to verify the hash against.
     * @return True if the password matches the hash, false otherwise.
     */
    fun verify(hash: String?, password: String?): Boolean {
        if (hash == null || password == null) return false
        return instance.verify(hash, password.toCharArray())
    }
}
