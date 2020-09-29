package com.aeccue.foundation.dagger.module

import com.aeccue.foundation.dagger.component.BaseDaggerSubcomponent
import dagger.Module
import dagger.multibindings.Multibinds

@Module
interface DaggerInjectorModule {

    @Multibinds
    fun factories(): Set<BaseDaggerSubcomponent.Factory<Any>>
}
