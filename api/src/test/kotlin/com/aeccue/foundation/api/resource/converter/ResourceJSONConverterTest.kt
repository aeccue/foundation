package com.aeccue.foundation.api.resource.converter

import com.aeccue.foundation.api.resource.Resource
import com.aeccue.foundation.test.TEST_CASES
import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.test.TEST_STRING_BASE64_ENCODED
import io.mockk.spyk
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ResourceJSONConverterTest {

    private val converter: ResourceJSONConverter<ResourceImplementation> = spyk()

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `converting resource to JSONObject should produce correct JSONObject`(testCase: ResourceImplementation) {
        val json = converter.from(testCase)
        json[Resource.Properties.KEY] `should be equal to` testCase.key
        json[Resource.Properties.CREATED_TIME] `should be equal to` testCase.createdTime
        json[Resource.Properties.LAST_MODIFIED] `should be equal to` testCase.lastModified
    }

    private fun testCases() = Stream.of(
            ResourceImplementation().apply {
                key = TEST_STRING
                createdTime = 10000000
                lastModified = 20000000
            },
            ResourceImplementation().apply {
                key = TEST_STRING_BASE64_ENCODED
                createdTime = 12345679
                lastModified = 987654321
            },
            ResourceImplementation().apply {
                key = "Test"
                createdTime = 50505050
                lastModified = 10101010
            }
    )
}

class ResourceImplementation : Resource<String>() {

    override val type = "Test"
}
