package com.aeccue.foundation.api.endpoint

import com.aeccue.foundation.api.resource.Resource
import com.aeccue.foundation.api.response.failure.InternalFailure
import com.aeccue.foundation.response.error.internal.IllegalMethodError
import io.mockk.mockk
import io.mockk.spyk
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be instance of`
import org.junit.jupiter.api.Test

class ResourceEndpointTest {

    private val endpoint: ResourceEndpoint<Resource<Nothing>> = spyk()
    private val resource: Resource<Nothing> = mockk()

    @Test
    fun `calling create should return IllegalMethodError`() {
        val response = endpoint.create(resource)
        response `should be instance of` InternalFailure::class
        (response as InternalFailure).error `should be instance of` IllegalMethodError::class
        response.error.method `should be equal to` "create"
    }

    @Test
    fun `calling get should return IllegalMethodError`() {
        val response = endpoint.get(resource)
        response `should be instance of` InternalFailure::class
        (response as InternalFailure).error `should be instance of` IllegalMethodError::class
        response.error.method `should be equal to` "get"
    }

    @Test
    fun `calling update should return IllegalMethodError`() {
        val response = endpoint.update(resource)
        response `should be instance of` InternalFailure::class
        (response as InternalFailure).error `should be instance of` IllegalMethodError::class
        response.error.method `should be equal to` "update"
    }

    @Test
    fun `calling replace should return IllegalMethodError`() {
        val response = endpoint.replace(resource)
        response `should be instance of` InternalFailure::class
        (response as InternalFailure).error `should be instance of` IllegalMethodError::class
        response.error.method `should be equal to` "replace"
    }

    @Test
    fun `calling delete should return IllegalMethodError`() {
        val response = endpoint.delete(resource)
        response `should be instance of` InternalFailure::class
        (response as InternalFailure).error `should be instance of` IllegalMethodError::class
        response.error.method `should be equal to` "delete"
    }
}
