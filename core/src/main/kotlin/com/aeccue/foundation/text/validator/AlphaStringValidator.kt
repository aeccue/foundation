package com.aeccue.foundation.text.validator

/**
 * A [StringValidator] that checks if a String only contains letters.
 */
object AlphaStringValidator : StringValidator {

    /**
     * Validates a String.
     *
     * @param [value] The String to validate.
     * @return True if the String is valid, false otherwise.
     */
    override fun validate(value: String): Boolean {
        for (c in value.toCharArray()) {
            if (c !in 'a'..'z' && c !in 'A'..'Z') return false
        }
        return true
    }
}
