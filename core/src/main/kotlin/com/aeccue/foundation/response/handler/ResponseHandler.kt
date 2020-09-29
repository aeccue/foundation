package com.aeccue.foundation.response.handler

import com.aeccue.foundation.Handler
import com.aeccue.foundation.response.Response

/**
 * A [Handler] that handles a [Response].
 *
 * @param [R] The class of the Response to handle.
 * @param [H] The class of the Handler that will handle the Response.
 */
interface ResponseHandler<R : Response, H> : Handler<R, H>
