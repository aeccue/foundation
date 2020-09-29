package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] that contains a message to be displayed to the user.
 *
 * @property [msg] The error message.
 */
interface MessageError : ErrorResponse {

    val msg: String
}
