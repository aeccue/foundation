package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] returned when a method that has no implementation has been invoked. The user
 * should be notified that this method is not supported or has not been implemented yet.
 */
interface UnsupportedOperationError : ErrorResponse {

    /**
     * The operation that is not supported.
     */
    val operation: String
}
