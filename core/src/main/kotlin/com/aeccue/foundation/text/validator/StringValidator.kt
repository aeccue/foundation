package com.aeccue.foundation.text.validator

/**
 * A validator to validate a String in a specific way.
 */
interface StringValidator {

    /**
     * Validates a String.
     *
     * @param [value] The String to validate.
     * @return True if the String is valid, false otherwise.
     */
    fun validate(value: String): Boolean
}
