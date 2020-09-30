package com.aeccue.foundation.response

/**
 * A [Response] that contains a payload.
 *
 * @param [P] The class of the payload.
 */
interface PayloadResponse<out P> : Response {

    /**
     * The optional payload of this response.
     */
    val payload: P?
}
