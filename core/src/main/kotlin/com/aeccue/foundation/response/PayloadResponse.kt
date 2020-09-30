package com.aeccue.foundation.response

/**
 * A [Response] that contains a payload.
 *
 * @param [P] The type of payload.
 */
interface PayloadResponse<out P> : Response {

    /**
     * The optional payload of this response.
     */
    val payload: P?
}
