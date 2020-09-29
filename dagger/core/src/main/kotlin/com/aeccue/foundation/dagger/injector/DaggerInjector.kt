package com.aeccue.foundation.dagger.injector

import com.aeccue.foundation.dagger.component.BaseDaggerSubcomponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * An injector that contains a set of [BaseDaggerSubcomponent.Factory] mappings and will attempt to
 * inject a target using its mappings. Only one can exist per Dagger component.
 *
 * @param [factories] The factories to use for injection, placed into a map using its class key.
 */
@Singleton
class DaggerInjector
@Inject constructor(factories: Set<@JvmSuppressWildcards BaseDaggerSubcomponent.Factory<Any>>) {

    private val factoryMappings = factories.associateBy {
        it.key
    }

    /**
     * Attempts to inject the target by finding its factory mapping using its class. If the target
     * is [InjectAware], its preInject and postInject will be called accordingly.
     *
     * @param [target] The target to attempt to inject.
     * @return True if successfully injected, false otherwise.
     */
    fun inject(target: Any): Boolean {
        val factory = factoryMappings[target::class.java] ?: return false
        (target as? InjectAware)?.preInject()
        factory.create(target).inject(target)
        (target as? InjectAware)?.postInject()
        return true
    }
}
