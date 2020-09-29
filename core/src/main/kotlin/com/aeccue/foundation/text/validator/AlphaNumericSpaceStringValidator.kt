package com.aeccue.foundation.text.validator

/**
 * A [StringValidator] that checks if a String only contains letters, digits and spaces.
 */
object AlphaNumericSpaceStringValidator : StringValidator {

    /**
     * Validates a String.
     *
     * @param [value] The String to validate.
     * @return True if the String is valid, false otherwise.
     */
    override fun validate(value: String): Boolean {
        for (c in value.toCharArray()) {
            if (c !in 'a'..'z' && c !in 'A'..'Z' && c !in '0'..'9' && c != ' ') return false
        }
        return true
    }
}
