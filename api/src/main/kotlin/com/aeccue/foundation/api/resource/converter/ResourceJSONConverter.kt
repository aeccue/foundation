package com.aeccue.foundation.api.resource.converter

import com.aeccue.foundation.api.resource.Resource
import org.json.simple.JSONObject

/**
 * A [ResourceConverter] that converts a [Resource] to a JSONObject and back.
 *
 * @param [R] The type of resource to convert.
 */
abstract class ResourceJSONConverter<R : Resource<*>> : ResourceConverter<R, JSONObject> {

    /**
     * Creates a JSONObject and adds the properties of a [Resource] into it.
     *
     * @param [resource] The resource to convert.
     * @return The JSONObject created with the resource.
     */
    override fun to(resource: R) = JSONObject().apply {
        put(Resource.Properties.KEY, resource.key)
        put(Resource.Properties.CREATED_TIME, resource.createdTime)
        put(Resource.Properties.LAST_MODIFIED, resource.lastModified)
    }
}
