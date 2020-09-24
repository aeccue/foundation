package com.aeccue.foundation.dagger.component

import com.aeccue.foundation.dagger.injector.DaggerInjection
import com.aeccue.foundation.dagger.injector.DaggerInjectorProvider
import com.aeccue.foundation.dagger.injector.Injectable

abstract class BaseDaggerComponent<T> {

    interface Factory<T> {

        fun create(): BaseDaggerComponent<T>
    }

    protected abstract fun inject(target: T)

    fun init(target: T) {
        (target as? Injectable)?.preInject()
        inject(target)
        (target as? Injectable)?.postInject()
        (target as? DaggerInjectorProvider)?.provide()?.let {
            DaggerInjection.register(it)
        }
    }
}
