package com.aeccue.foundation.api.resource

/**
 * An embeddable [Resource] that, when embedded, contains only the necessary information of the
 * resource.
 *
 * @param [K] The type of key for this resource.
 */
abstract class EmbeddableResource<K> : Resource<K>() {

    /**
     * Converts this resource to its embedded version.
     *
     * @return The embeddable version of this resource.
     */
    abstract fun toEmbedded(): EmbeddableResource<K>
}
