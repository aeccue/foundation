package com.aeccue.foundation.response.error

/**
 * A [MessageError] returned when an error occurs as a result of a programming error. This error
 * should not happen and should be logged to be fixed at a later time.
 *
 * @property [tag] The tag of the class in which this error occurred.
 * @property [method] The name of the method in which this error occured.
 * @property [error] An optional error message to be used for logging.
 * @property [cause] An optional cause for this error.
 */
interface InternalError : MessageError {

    val tag: String

    val method: String

    val error: String?

    val cause: Throwable?

    override val msg get() = "[$tag | $method] $error"
}
