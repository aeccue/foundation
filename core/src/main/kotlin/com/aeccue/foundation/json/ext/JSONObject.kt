package com.aeccue.foundation.json.ext

import org.json.simple.JSONObject

/**
 * Attempts to retrieve the value associated to a key as the specified type from this JSONObject.
 * If a value cannot be retrieved, the default value is returned.
 *
 * @param [T] The type of the value to retrieve.
 * @param [key] The key to the value to retrieve.
 * @param [default] The default value to return if none is found.
 * @return The retrieved value or the default value.
 */
inline fun <reified T> JSONObject.get(key: String, default: T): T = (get(key) as? T) ?: default

/**
 * Attempts to retrieve the value associated to a key as the specified type from this JSONObject. A
 * null value is not allowed.
 *
 * @param [T] The type of the value to retrieve.
 * @param [key] The key to the value to retrieve.
 * @return The retrieved value.
 * @throws [NoSuchElementException] If this JSONObject does not contain the given key, or if the
 * value cannot be converted to the given type.
 */
inline fun <reified T> JSONObject.getOrThrow(key: String): T =
        get(key) as? T ?: throw NoSuchElementException()

/**
 * Attempts to retrieve the value associated to a key as the specified type from this JSONObject. A
 * null value is allowed.
 *
 * @param [T] The type of the value to retrieve.
 * @param [key] The key to the value to retrieve.
 * @return The retrieved value.
 * @throws [NoSuchElementException] If this JSONObject does not contain the given key, or if the
 * value cannot be converted to the given type.
 */
inline fun <reified T> JSONObject.getOrThrowNullable(key: String): T? {
    if (!containsKey(key)) throw NoSuchElementException()
    return get(key)?.let {
        it as? T ?: throw NoSuchElementException()
    }
}

/**
 * Attempts to retrieve the value associated to a key as the specified type from this JSONObject.
 * If a value cannot be retrieved, an optional default value is returned, or null if none is defined.
 *
 * @param [T] The type of the value to retrieve.
 * @param [key] The key to the value to retrieve.
 * @param [default] The optional default value to return if none is found. Defaults to null.
 * @return The retrieved value, the default value or null.
 */
inline fun <reified T> JSONObject.getOptional(key: String, default: T? = null): T? =
        get(key) as? T ?: default

/**
 * Attempts to retrieve the value associated to a key as the specified type from this JSONObject.
 * If a value cannot be retrieved, an optional default value is returned, or null if none is defined.
 * Value may be null.
 *
 * @param [T] The type of the value to retrieve.
 * @param [key] The key to the value to retrieve.
 * @param [default] The optional default value to return if none is found. Defaults to null.
 * @return The retrieved value, the default value or null.
 */
inline fun <reified T> JSONObject.getNullable(key: String, default: T? = null) : T? {
    if (!containsKey(key)) return default
    return get(key)?.let {
        it as? T ?: default
    }
}
