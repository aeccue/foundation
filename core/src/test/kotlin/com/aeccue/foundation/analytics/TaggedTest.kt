package com.aeccue.foundation.analytics

import com.aeccue.foundation.test.TEST_STRING
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class TaggedTest {

    @Test
    fun `tagged class with default tag`() {
        val testClass = DefaultTaggedClass()
        testClass.tag `should be equal to` "DefaultTaggedClass"
    }

    @Test
    fun `tagged class with tag overridden`() {
        val testClass = SpecifiedTaggedClass()
        testClass.tag `should be equal to` TEST_STRING
    }
}

private class DefaultTaggedClass : Tagged

private class SpecifiedTaggedClass : Tagged {

    override val tag = TEST_STRING
}
