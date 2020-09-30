package com.aeccue.foundation.api.response.failure

import com.aeccue.foundation.api.response.EndpointFailure
import com.aeccue.foundation.response.error.ResourceNotFoundError

/**
 * A [ResourceNotFoundError] failure response.
 *
 * @property [resource] The name of the resource that cannot be found.
 */
class ResourceNotFound(override val resource: String) : EndpointFailure(), ResourceNotFoundError
