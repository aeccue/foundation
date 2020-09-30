package com.aeccue.foundation.api.response.failure

import com.aeccue.foundation.api.response.EndpointFailure
import com.aeccue.foundation.response.error.internal.InternalError

/**
 * An [InternalError] failure response.
 *
 * @property [error] The internal error.
 */
class InternalFailure(val error: InternalError) : EndpointFailure()
