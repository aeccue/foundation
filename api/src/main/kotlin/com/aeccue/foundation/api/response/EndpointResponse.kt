package com.aeccue.foundation.api.response

import com.aeccue.foundation.api.endpoint.Endpoint
import com.aeccue.foundation.response.PayloadResponse
import com.aeccue.foundation.response.Response

/**
 * A response returned by an [Endpoint].
 *
 * @param [T] The type of actual return value.
 */
sealed class EndpointResponse<out T> : Response

/**
 * An [EndpointResponse] returned when the request is successful.
 *
 * @param [T] The type of the actual return value.
 * @property [payload] The return value of the successful request.
 */
class EndpointSuccess<out T>(override val payload: T?) : EndpointResponse<T>(), PayloadResponse<T>

/**
 * An [EndpointResponse] returned when the request has failed.
 */
abstract class EndpointFailure : EndpointResponse<Nothing>()
