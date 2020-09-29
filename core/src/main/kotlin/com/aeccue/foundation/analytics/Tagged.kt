package com.aeccue.foundation.analytics

/**
 * An interface that adds a tag to the implementing class for use in logging and analytics.
 */
interface Tagged {

    /**
     * The tag, defaulting to the simple name of the implementing class.
     */
    val tag: String get() = this::class.java.simpleName
}
