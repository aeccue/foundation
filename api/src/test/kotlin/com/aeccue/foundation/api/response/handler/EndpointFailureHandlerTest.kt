package com.aeccue.foundation.api.response.handler

import com.aeccue.foundation.api.response.failure.InternalFailure
import com.aeccue.foundation.api.response.failure.InvalidParameter
import com.aeccue.foundation.api.response.failure.ResourceAlreadyExists
import com.aeccue.foundation.api.response.failure.ResourceNotFound
import com.aeccue.foundation.test.TEST_STRING
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.amshove.kluent.`should be true`
import org.junit.jupiter.api.Test

class EndpointFailureHandlerTest {

    private val with = TEST_STRING

    @Test
    fun `handling InternalFailure should return true`() {
        val handler = createMockHandler()
        val failure: InternalFailure = mockk()
        every { handler["handleInternalFailure"](failure, with) } returns true

        handler.handle(failure, with).`should be true`()
    }

    @Test
    fun `handling InvalidParameter should return true`() {
        val handler = createMockHandler()
        val failure: InvalidParameter = mockk()
        every { handler["handleInvalidParameter"](failure, with) } returns true

        handler.handle(failure, with).`should be true`()
    }

    @Test
    fun `handling ResourceAlreadyExists should return true`() {
        val handler = createMockHandler()
        val failure: ResourceAlreadyExists = mockk()
        every { handler["handleResourceAlreadyExists"](failure, with) } returns true

        handler.handle(failure, with).`should be true`()
    }

    @Test
    fun `handling ResourceNotFound should return true`() {
        val handler = createMockHandler()
        val failure: ResourceNotFound = mockk()
        every { handler["handleResourceNotFound"](failure, with) } returns true

        handler.handle(failure, with).`should be true`()
    }

    private fun createMockHandler(): EndpointFailureHandler<String> = spyk()
}
