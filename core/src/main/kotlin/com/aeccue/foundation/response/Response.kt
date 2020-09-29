package com.aeccue.foundation.response

/**
 * A response to a request. This interface is meant to be use for created sealed classes that
 * contains both success and error responses, as oppose to throwing Exceptions, which are not
 * caught explicitly in Kotlin.
 */
interface Response
