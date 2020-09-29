package com.aeccue.foundation.response

/**
 * A [Response] that contains a payload.
 *
 * @param [P] The class of the payload.
 * @property [payload] The payload of this response.
 */
interface PayloadResponse<out P> : Response {

    val payload: P
}
