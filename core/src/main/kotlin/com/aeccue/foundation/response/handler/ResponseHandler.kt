package com.aeccue.foundation.response.handler

import com.aeccue.foundation.Handler
import com.aeccue.foundation.response.Response

/**
 * A [Handler] that handles a [Response].
 *
 * @param [R] The type of Response to handle.
 * @param [H] The type of class that will handle the Response.
 */
interface ResponseHandler<in R : Response, in H> : Handler<R, H>
