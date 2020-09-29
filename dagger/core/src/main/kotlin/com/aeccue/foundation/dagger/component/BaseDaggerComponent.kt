package com.aeccue.foundation.dagger.component

import com.aeccue.foundation.dagger.injector.DaggerInjection
import com.aeccue.foundation.dagger.injector.DaggerInjectorProvider
import com.aeccue.foundation.dagger.injector.InjectAware

/**
 * This class can be extended to add the Dagger component into the [DaggerInjection] process. The
 * [init] method must be invoked to initialize this process. Subclasses must also have the Dagger
 * Component annotation.
 *
 * @param [T] The class of the target to inject with this component.
 */
abstract class BaseDaggerComponent<in T> {

    /**
     * This class can be extended to create a Factory for the [BaseDaggerComponent]. The [create]
     * method has already been provided. Subclasses must also have the Dagger Component.Factory
     * annotation.
     *
     * @param [T] The class of the injection target of the component to create.
     */
    interface Factory<in T> {

        /**
         * This method will be implemented automatically by Dagger to create an instance of the
         * [BaseDaggerComponent].
         *
         * @return The instance of the component created.
         */
        fun create(): BaseDaggerComponent<T>
    }

    /**
     * Injects a target of this component with all the required dependencies created by Dagger.
     *
     * @param [target] The target to inject.
     */
    protected abstract fun inject(target: T)

    /**
     * Initializes this component with a target. The target will be automatically injected. However,
     * if the targe is an instance of [InjectAware], preInject and postInject will be called
     * accordingly as well. If the target is also an instance of [DaggerInjectorProvider], it will
     * be automatically registered to [DaggerInjection], so that any of its subcomponents can be
     * injected by the DaggerInjection as well.
     *
     * @param [target] The target to inject.
     */
    fun init(target: T) {
        (target as? InjectAware)?.preInject()
        inject(target)
        (target as? InjectAware)?.postInject()
        (target as? DaggerInjectorProvider)?.provide()?.let {
            DaggerInjection.register(it)
        }
    }
}
