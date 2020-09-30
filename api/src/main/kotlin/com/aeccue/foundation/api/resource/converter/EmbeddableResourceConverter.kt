package com.aeccue.foundation.api.resource.converter

import com.aeccue.foundation.api.resource.EmbeddableResource

/**
 * An [EmbeddableResource] that will also convert the embedded version of the resource to its source
 * and back.
 *
 * @param [E] The type of the embeddable resource.
 * @param [S] The type of the source.
 */
interface EmbeddableResourceConverter<E : EmbeddableResource<*>, S> : ResourceConverter<E, S> {

    /**
     * Creates the embedded version of a resource from a source.
     *
     * @param [source] The source of the resource.
     * @return The embedded version of the resource created from the source.
     */
    fun toEmbeddable(source: S): E

    /**
     * Converts the embedded version of a resource to its source.
     *
     * @param [resource] The embeddable resource to convert.
     * @return The source of the resource.
     */
    fun fromEmbeddable(resource: E): S
}
