package com.aeccue.foundation.text.validator

import javax.mail.internet.AddressException
import javax.mail.internet.InternetAddress

/**
 * A [StringValidator] that checks if a String is a valid email address.
 */
object EmailStringValidator : StringValidator {

    /**
     * Validates a String.
     *
     * @param [value] The String to validate.
     * @return True if the String is valid, false otherwise.
     */
    override fun validate(value: String): Boolean =
            try {
                InternetAddress(value).validate()
                true
            } catch (e: AddressException) {
                false
            }
}
