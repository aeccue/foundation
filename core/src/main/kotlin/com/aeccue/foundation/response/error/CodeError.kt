package com.aeccue.foundation.response.error

/**
 * A [MessageError] that includes a message that should be displayed to the users.
 */
interface CodeError : MessageError {

    /**
     * The error code.
     */
    val code: Int
}
