package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] returned when an invalid parameter is passed into a function. This error is
 * meant to be returned when user input is invalid.
 */
interface InvalidParameterError : ErrorResponse {

    /**
     * The name of the parameter that is invalid.
     */
    val parameter: String
}
