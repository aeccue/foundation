package com.aeccue.foundation.dagger.injector

/**
 * DaggerInjection will be used to attempt to inject any targets with the [DaggerInjector]
 * registered to it. This object serves as a main entry point to dependency injection, so that the
 * target itself does not know how it is injected.
 */
object DaggerInjection {

    private val injectors = mutableListOf<DaggerInjector>()

    /**
     * Registers the [DaggerInjector], to be used for injection.
     *
     * @param [injector] The injector to register.
     */
    fun register(injector: DaggerInjector) {
        injectors.add(injector)
    }

    /**
     * Unregisters a previously registered [DaggerInjector]. If the injector was not previously
     * registered, do nothing.
     *
     * @param [injector] The injector to unregister.
     */
    fun unregister(injector: DaggerInjector) {
        injectors.remove(injector)
    }

    /**
     * Attempts to inject the target. All registered injectors are iterated through in an attempt to
     * inject the target.
     *
     * @param [target] The target to inject.
     * @throws [IllegalArgumentException] If no registered injectors can inject the target.
     */
    fun inject(target: Any) {
        for (injector in injectors) {
            if (injector.inject(target)) return
        }

        throw IllegalArgumentException("Dagger injector does not exist for target [${target::class.simpleName}]")
    }
}
