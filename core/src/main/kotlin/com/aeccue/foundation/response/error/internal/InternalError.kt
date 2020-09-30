package com.aeccue.foundation.response.error.internal

import com.aeccue.foundation.response.error.MessageError

/**
 * A [MessageError] returned when an error occurs as a result of a programming error. This error
 * should not happen and should be logged, investigated and fixed.
 *
 * @property [tag] The tag of the class in which this error occurred.
 * @property [method] The name of the method in which this error occured.
 * @property [error] An optional error message to be used for logging.
 * @property [cause] An optional cause for this error.
 */
open class InternalError(open val tag: String,
                         open val method: String,
                         open val error: String? = null,
                         open val cause: Throwable? = null) : MessageError {

    override val msg get() = "[$tag | $method] $error"
}
