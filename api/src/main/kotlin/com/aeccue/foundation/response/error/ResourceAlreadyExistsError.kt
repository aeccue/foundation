package com.aeccue.foundation.response.error

/**
 * An [ErrorResponse] returned when the resource in question already exists. As a result, the
 * resource cannot be created, or changed.
 */
interface ResourceAlreadyExistsError : ErrorResponse {

    /**
     * The name of the resource that already exists.
     */
    val resource: String
}
