package com.aeccue.foundation.dagger.injector

open class InjectionTarget {

    fun inject() {}
}

class InjectAwareTarget : InjectionTarget(), InjectAware

class DaggerInjectorProviderTarget(private val injector: DaggerInjector)
    : InjectionTarget(), DaggerInjectorProvider {

    override fun provide() = injector
}
