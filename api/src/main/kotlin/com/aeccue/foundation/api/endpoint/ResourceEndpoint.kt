package com.aeccue.foundation.api.endpoint

import com.aeccue.foundation.api.resource.Resource
import com.aeccue.foundation.api.response.EndpointResponse
import com.aeccue.foundation.api.response.failure.InternalFailure
import com.aeccue.foundation.response.error.internal.IllegalMethodError

/**
 * An [Endpoint] that handles creating, retrieving, updating, replacing and deleting a [Resource].
 *
 * @param [R] The type of resource for this endpoint.
 */
abstract class ResourceEndpoint<R : Resource<*>> : Endpoint {

    /**
     * Creates a resource.
     *
     * @param [resource] The resource to create.
     * @return A success response containing the created resource, or a failure response.
     */
    open fun create(resource: R): EndpointResponse<R> {
        return InternalFailure(IllegalMethodError(tag, "create"))
    }

    /**
     * Retrieves a resource.
     *
     * @param [resource] The resource to retrieve.
     * @return A success response containing the retrieved resource, or a failure response.
     */
    open fun get(resource: R): EndpointResponse<R> {
        return InternalFailure(IllegalMethodError(tag, "get"))
    }

    /**
     * Updates a resource.
     *
     * @param [resource] The resource to update.
     * @return A success response containing the updated resource, or a failure response.
     */
    open fun update(resource: R): EndpointResponse<R> {
        return InternalFailure(IllegalMethodError(tag, "update"))
    }

    /**
     * Replaces a resource.
     *
     * @param [resource] The resource to replace.
     * @return A success response containing the replaced resource, or a failure response.
     */
    open fun replace(resource: R): EndpointResponse<R> {
        return InternalFailure(IllegalMethodError(tag, "replace"))
    }

    /**
     * Deletes a resource.
     *
     * @param [resource] The resource to delete.
     * @return A success response containing the deleted resource, or a failure response.
     */
    open fun delete(resource: R): EndpointResponse<R> {
        return InternalFailure(IllegalMethodError(tag, "delete"))
    }
}
