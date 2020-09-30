package com.aeccue.foundation.response.error.internal

/**
 * An [InternalError] returned when a method is invoked when it should not have been able to. This
 * error should be returned when a programming error allowed a method to be invoked when it should
 * be impossible to do so.
 *
 * @property [tag] The tag of the class in which this error occurred.
 * @property [method] The name of the method that should not have been invoked.
 * @property [cause] An optional cause for this error.
 */
open class IllegalMethodError(override val tag: String,
                              override val method: String,
                              override val cause: Throwable? = null)
    : InternalError(tag, method, "Illegal method invoked.", cause)
