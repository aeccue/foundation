package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] returned when the user input is of an unsupported format and cannot continue
 * with the request.
 */
interface UnsupportedFormatError : ErrorResponse {

    /**
     * The format that is not supported.
     */
    val format: String
}
