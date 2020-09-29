package com.aeccue.foundation.response.handler

import com.aeccue.foundation.Handler
import com.aeccue.foundation.response.error.InternalError

/**
 * A [Handler] that handles an [InternalError].
 *
 * @param [H] That class of the Handler that will handle the InternalError.
 */
interface InternalErrorHandler<H> : Handler<InternalError, H>
