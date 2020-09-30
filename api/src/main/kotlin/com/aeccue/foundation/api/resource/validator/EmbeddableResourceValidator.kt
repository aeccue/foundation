package com.aeccue.foundation.api.resource.validator

import com.aeccue.foundation.api.resource.EmbeddableResource

/**
 * A [ResourceValidator] that validates an [EmbeddableResource].
 *
 * @param [E] The type of resource to validate.
 */
interface EmbeddableResourceValidator<in E : EmbeddableResource<*>> : ResourceValidator<E> {

    /**
     * Validates the embeddable version of the resource.
     *
     * @param [resource] The embeddable resource to validate.
     * @return True if the embeddable version of the resource is valid, false otherwise.
     */
    fun validateEmbeddable(resource: E): Boolean
}
