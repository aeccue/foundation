package com.aeccue.foundation.response.error

/**
 * A [MessageError] returned when an invalid parameter is passed into a function. This error is
 * meant to be returned when user input is invalid.
 *
 * @property [parameter] The name of the parameter that is invalid.
 */
interface InvalidParameterError : MessageError {

    val parameter: String

    override val msg get() = "Invalid $parameter"
}
