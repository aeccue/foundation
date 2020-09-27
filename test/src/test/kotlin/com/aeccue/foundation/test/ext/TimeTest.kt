package com.aeccue.foundation.test.ext

import com.aeccue.foundation.test.TEST_CASES
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TimeTest {

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `creating an Instant from a Long should produce the correct Instant`(milli: Long) {
        val instant = milli.toInstant()
        instant.toEpochMilli() `should be equal to` milli
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `creating a Clock from a Long should produce the correct Clock`(milli: Long) {
        val clock = milli.toClock()
        clock.instant().toEpochMilli() `should be equal to` milli
        clock.millis() `should be equal to` milli
    }

    private fun testCases() = Stream.of(
            120,
            5000000,
            1253491,
            Long.MAX_VALUE,
            0
    )
}
