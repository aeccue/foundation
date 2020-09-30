package com.aeccue.foundation.api.response.failure

import com.aeccue.foundation.api.response.EndpointFailure
import com.aeccue.foundation.response.error.InvalidParameterError

/**
 * An [InvalidParameterError] failure response.
 *
 * @property [parameter] The name of the parameter that is invalid.
 */
class InvalidParameter(override val parameter: String) : EndpointFailure(), InvalidParameterError
