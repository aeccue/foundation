package com.aeccue.foundation.api.response.failure

import com.aeccue.foundation.api.response.EndpointFailure
import com.aeccue.foundation.response.error.ResourceAlreadyExistsError

/**
 * A [ResourceAlreadyExistsError] failure response.
 *
 * @property [resource] The name of the resource that already exists.
 */
class ResourceAlreadyExists(override val resource: String) : EndpointFailure(), ResourceAlreadyExistsError
