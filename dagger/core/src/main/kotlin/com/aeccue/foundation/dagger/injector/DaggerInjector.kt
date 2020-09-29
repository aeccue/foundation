package com.aeccue.foundation.dagger.injector

import com.aeccue.foundation.dagger.component.BaseDaggerSubcomponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DaggerInjector
@Inject constructor(factories: Set<@JvmSuppressWildcards BaseDaggerSubcomponent.Factory<Any>>) {

    private val factoryMappings = factories.associateBy {
        it.key
    }

    fun inject(target: Any): Boolean {
        val factory = factoryMappings[target::class.java] ?: return false
        (target as? Injectable)?.preInject()
        factory.create(target).inject(target)
        (target as? Injectable)?.postInject()
        return true
    }
}
