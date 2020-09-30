package com.aeccue.foundation.api.endpoint

import com.aeccue.foundation.api.response.EndpointResponse

/**
 * An [Endpoint] that performs only one task.
 *
 * @param [I] The type of input for this endpoint.
 * @param [O] The type of output for a request to this endpoint.
 */
interface CallableEndpoint<in I, out O> : Endpoint {

    /**
     * Calls this endpoint and attempt to fulfill the request.
     *
     * @param [input] The input for the request.
     * @return The response containing the output for the request.
     */
    fun call(input: I): EndpointResponse<O>
}
