package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] that contains a message to be displayed to the user.
 */
interface MessageError : ErrorResponse {

    /**
     * The error message.
     */
    val msg: String
}
