package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] returned when a resource cannot be found.
 */
interface ResourceNotFoundError : ErrorResponse {

    /**
     * The name of the resource that cannot be found.
     */
    val resource: String
}
