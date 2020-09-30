package com.aeccue.foundation.api.resource.converter

import com.aeccue.foundation.analytics.Tagged
import com.aeccue.foundation.api.resource.Resource


/**
 * A converter that converts a resource to a source, and vice versa.
 *
 * @param [R] The type of resource to convert.
 * @param [S] The type of source to convert the resource to.
 */
interface ResourceConverter<R : Resource<*>, S> : Tagged {

    /**
     * Creates a resource from a source.
     *
     * @param [source] The source of the resource.
     * @return The resource created from the source.
     */
    fun to(source: S): R

    /**
     * Converts a resource to its source.
     *
     * @param [resource] The resource to convert.
     * @return The source of the resource.
     */
    fun from(resource: R): S
}
