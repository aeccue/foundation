package com.aeccue.foundation.api.resource

/**
 * A resource that contains information that represents an entity, which can then be stored or
 * passed around.
 *
 * @param [K] The type of key for this resource.
 */
abstract class Resource<K> {

    /**
     * The name of the properties in this resource.
     */
    object Properties {

        const val CREATED_TIME = "createdTime"
        const val KEY = "key"
        const val LAST_MODIFIED = "lastModified"
    }

    /**
     * The type of this resource.
     */
    abstract val type: String

    /**
     * The key (or ID) of this resource.
     */
    var key: K? = null

    /**
     * The time of creation in milliseconds.
     */
    var createdTime: Long = System.currentTimeMillis()

    /**
     * The time of the last modification in milliseconds.
     */
    var lastModified: Long = System.currentTimeMillis()
}
