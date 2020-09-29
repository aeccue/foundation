package com.aeccue.foundation.response.error

/**
 * An [InternalError] returned when a method is invoked when it should not have been able to. This
 * error should be returned when a programming error allowed a method to be invoked when it should
 * be impossible to do so.
 *
 * @property [method] The name of the method that should not have been invoked.
 */
interface IllegalMethodError : InternalError {

    override val error get() = "illegal method invoked"
}
