package com.aeccue.foundation.dagger.injector

/**
 * Indicates that the implementing class can provide a [DaggerInjector].
 */
interface DaggerInjectorProvider {

    /**
     * Provides the [DaggerInjector]
     *
     * @return The DaggerInjector.
     */
    fun provide(): DaggerInjector
}
