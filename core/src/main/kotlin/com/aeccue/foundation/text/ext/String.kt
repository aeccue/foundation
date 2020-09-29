package com.aeccue.foundation.text.ext

import com.aeccue.foundation.text.validator.StringValidator

/**
 * All possible letter characters.
 */
val String.Companion.LETTERS: String get() = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

/**
 * All possible digit characters.
 */
val String.Companion.DIGITS: String get() = "0123456789"

/**
 * All possible letter and digit characters.
 */
val String.Companion.ALPHANUMERIC: String get() = "$LETTERS$DIGITS"

/**
 * Validates this String against the given constraints. Minimum length must be 0 or greater, and
 * less than max length.
 *
 * @param [maxLength] The maximum allowed length of this String.
 * @param [minLength] The minimum allowed length of this String. Defaults to 0.
 * @param [nullable] If this String can be null or not. Defaults to false.
 * @param [validator] An optional [StringValidator] to be used to further validate the String.
 * @return True if this String is valid, false otherwise.
 * @throws [IllegalArgumentException] If [maxLength] is less than [minLength] or if [minLength] is
 * less than 0.
 */
fun String?.validate(maxLength: Int,
                     minLength: Int = 0,
                     nullable: Boolean = false,
                     validator: StringValidator? = null)
        : Boolean {
    if (maxLength < minLength || minLength < 0) throw IllegalArgumentException()
    if (this == null) return nullable
    if (minLength > 0 && isBlank()) return false
    if (length < minLength || length > maxLength) return false
    if (validator?.validate(this) == false) return false
    return true
}

/**
 * Combines all continuous whitespace character in this String into one normal space character.
 *
 * @return This string with all whitespace characters normalized.
 */
fun String.normalizeSpace(): String = this.replace("\\s+".toRegex(), " ")
