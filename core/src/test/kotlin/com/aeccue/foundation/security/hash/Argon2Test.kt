package com.aeccue.foundation.security.hash

import com.aeccue.foundation.test.IOTestCase
import com.aeccue.foundation.test.TEST_CASES
import com.aeccue.foundation.test.TEST_STRING
import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.amshove.kluent.`should not be equal to`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Argon2Test {

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `hashed password should not be the same as the password`(testCase: IOTestCase<String, String>) {
        val hash = Argon2.hash(testCase.input)
        hash `should not be equal to` testCase.input
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `predetermined hash should successfully verify with valid password`(testCase: IOTestCase<String, String>) {
        Argon2.verify(testCase.output, testCase.input).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(TEST_CASES)
    fun `predetermined hash should fail when verifying with invalid password`(testCase: IOTestCase<String, String>) {
        Argon2.verify(testCase.output, "${testCase.input}!").`should be false`()
    }

    @Suppress("unused")
    private fun testCases() = Stream.of(
            IOTestCase(TEST_STRING, "\$argon2id\$v=19\$m=65536,t=2,p=2\$cEQwREZhZE1kYUhLOVZNYw\$+h3j62gHIh/yRLS6tLX0u8KhdhcLBmZpxhQ8zqW4tLY"),
            IOTestCase("password", "\$argon2id\$v=19\$m=65536,t=2,p=2\$djZiQnlVNHg2SFNJZGp2Zg\$ND1k26bhpE4ahDfcsSXLa/hsoSGh0+79I5LnpwSTQAU"),
            IOTestCase("1234blah", "\$argon2id\$v=19\$m=65536,t=2,p=2\$NWt5ZGJuNGx1Q2xPZDUwRg\$D7HixGzUpIP4bhP/h0k33oYdWpQ7UHa6zyKICuuPeac"),
            IOTestCase("       ", "\$argon2id\$v=19\$m=65536,t=2,p=2\$MVNOaXQ3MkV0NEJjbE9GaQ\$mzqlSyBu7/7IA1E8d/XKkeIJCVRmzoxj4YSWZqrv1Xo")
    )
}
