package com.aeccue.foundation.io.ext

import com.aeccue.foundation.test.TEST_STRING
import com.aeccue.foundation.test.TEST_STRING_BASE64_ENCODED
import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import java.io.Writer

class WriterTest {

    @Test
    fun `commit to writer should write and then flush only once`() {
        val writer: Writer = spyk()
        writer.commit {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
        }

        verify(exactly = 1) {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
            writer.flush()
        }
    }

    @Test
    fun `commit to writer should write and then flush in that order`() {
        val writer: Writer = spyk()
        writer.commit {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
        }

        verifyOrder {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
            writer.flush()
        }
    }

    @Test
    fun `commit to writer should write and then close only once`() {
        val writer: Writer = spyk()
        writer.commitAndClose {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
        }

        verify(exactly = 1) {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
            writer.close()
        }
    }

    @Test
    fun `commit and close to writer to write and then close in that order`() {
        val writer: Writer = spyk()
        writer.commitAndClose {
            write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
        }

        verifyOrder {
            writer.write(TEST_STRING)
            writer.write(TEST_STRING_BASE64_ENCODED)
            writer.close()
        }
    }
}
