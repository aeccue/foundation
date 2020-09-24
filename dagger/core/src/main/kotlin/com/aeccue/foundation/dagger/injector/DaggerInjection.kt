package com.aeccue.foundation.dagger.injector

object DaggerInjection {

    private val injectors = mutableListOf<DaggerInjector>()

    fun register(injector: DaggerInjector) {
        injectors.add(injector)
    }

    fun unregister(injector: DaggerInjector) {
        injectors.remove(injector)
    }

    fun inject(target: Any) {
        for (injector in injectors) {
            if (injector.inject(target)) {
                return
            }
        }

        throw IllegalArgumentException("Dagger injector does not exist for target [${target::class.simpleName}]")
    }
}
