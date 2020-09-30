package com.aeccue.foundation.response.handler

import com.aeccue.foundation.Handler
import com.aeccue.foundation.response.error.internal.InternalError

/**
 * A [Handler] that handles an [InternalError].
 *
 * @param [H] That type of class that will handle the InternalError.
 */
interface InternalErrorHandler<H> : Handler<InternalError, H>
