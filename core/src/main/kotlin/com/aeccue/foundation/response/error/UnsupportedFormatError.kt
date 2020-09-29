package com.aeccue.foundation.response.error

/**
 * An returned when the user input is of an unsupported format, and cannot continue with the
 * request.
 *
 * @property [format] The format that is not supported.
 */
interface UnsupportedFormatError : ErrorResponse {

    val format: String
}
