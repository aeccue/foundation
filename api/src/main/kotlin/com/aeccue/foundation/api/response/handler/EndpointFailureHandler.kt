package com.aeccue.foundation.api.response.handler

import com.aeccue.foundation.api.response.EndpointFailure
import com.aeccue.foundation.api.response.failure.InternalFailure
import com.aeccue.foundation.api.response.failure.InvalidParameter
import com.aeccue.foundation.api.response.failure.ResourceAlreadyExists
import com.aeccue.foundation.api.response.failure.ResourceNotFound
import com.aeccue.foundation.response.handler.ResponseHandler

/**
 * A [ResponseHandler] for [EndpointFailure].
 *
 * @param [H] The type of object to handle the failure with.
 */
abstract class EndpointFailureHandler<in H> : ResponseHandler<EndpointFailure, H> {

    /**
     * Handles an [EndpointFailure].
     *
     * @param [target] The failure.
     * @param [with] What to handle the failure with.
     * @return True if failure was handled, false otherwise.
     */
    override fun handle(target: EndpointFailure, with: H): Boolean =
            when (target) {
                is InternalFailure -> handleInternalFailure(target, with)
                is InvalidParameter -> handleInvalidParameter(target, with)
                is ResourceAlreadyExists -> handleResourceAlreadyExists(target, with)
                is ResourceNotFound -> handleResourceNotFound(target, with)
                else -> false
            }

    /**
     * Handles an [InternalFailure].
     *
     * @param [failure] The failure.
     * @param [with] What to handle the failure with.
     * @return True if failure was handled, false otherwise.
     */
    protected abstract fun handleInternalFailure(failure: InternalFailure, with: H): Boolean

    /**
     * Handles an [InvalidParameter].
     *
     * @param [failure] The failure.
     * @param [with] What to handle the failure with.
     * @return True if failure was handled, false otherwise.
     */
    protected abstract fun handleInvalidParameter(failure: InvalidParameter, with: H): Boolean

    /**
     * Handles an [ResourceAlreadyExists].
     *
     * @param [failure] The failure.
     * @param [with] What to handle the failure with.
     * @return True if failure was handled, false otherwise.
     */
    protected abstract fun handleResourceAlreadyExists(failure: ResourceAlreadyExists, with: H): Boolean

    /**
     * Handles an [ResourceNotFound].
     *
     * @param [failure] The failure.
     * @param [with] What to handle the failure with.
     * @return True if failure was handled, false otherwise.
     */
    protected abstract fun handleResourceNotFound(failure: ResourceNotFound, with: H): Boolean
}
