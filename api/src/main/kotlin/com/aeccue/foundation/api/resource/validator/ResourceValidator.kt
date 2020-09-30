package com.aeccue.foundation.api.resource.validator

import com.aeccue.foundation.analytics.Tagged
import com.aeccue.foundation.api.resource.Resource

/**
 * A validator to validate the information in a [Resource].
 *
 * @param [R] The type of resource to validate.
 */
interface ResourceValidator<in R : Resource<*>> : Tagged {

    /**
     * Validates a resource.
     *
     * @param [resource] The resource to validate.
     * @return True if the resource is valid, false otherwise.
     */
    fun validate(resource: R): Boolean
}
