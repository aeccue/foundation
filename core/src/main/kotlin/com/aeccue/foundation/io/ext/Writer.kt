package com.aeccue.foundation.io.ext

import java.io.Writer

/**
 * Invokes a function with this writer and flushes the stream.
 *
 * @param [execute] The function to invoke with the writer.
 */
inline fun Writer.commit(execute: Writer.() -> Unit) {
    execute()
    flush()
}

/**
 * Invokes a function with this writer and closes the stream.
 *
 * @param [execute] The function to execute with the writer.
 */
inline fun Writer.commitAndClose(execute: Writer.() -> Unit) {
    execute()
    close()
}
