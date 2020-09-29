package com.aeccue.foundation.response.error

/**
 * A [MessageError] that includes a message that should be displayed to the users.
 *
 * @property [code] The error code.
 */
interface CodeError : MessageError {

    val code: Int
}
