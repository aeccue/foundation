package com.aeccue.foundation.dagger.component

import dagger.Binds
import dagger.BindsInstance
import dagger.multibindings.IntoSet

interface BaseDaggerSubcomponent<in T> {

    abstract class Factory<T, out C : BaseDaggerSubcomponent<T>> {

        abstract val key: Class<T>

        abstract fun create(@BindsInstance target: T): C
    }

    interface FactoryMapping<T, C : BaseDaggerSubcomponent<T>, F : Factory<T, C>> {

        @Binds
        @IntoSet
        fun mapping(factory: F): Factory<Any, BaseDaggerSubcomponent<Any>>
    }

    fun inject(target: T)
}
