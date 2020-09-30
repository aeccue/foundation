package com.aeccue.foundation

/**
 * An interface that dictates that the implementing class is capable of handling an object of type
 * [T] using an object of type [H].
 *
 * @param [T] The type of class to handle.
 * @param [H] The type of class to use for handling.
 */
interface Handler<in T, in H> {

    /**
     * Handles a target.
     *
     * @param [target] The target to handle.
     * @param [with] What to use for handling.
     * @return True if target was handled, false otherwise.
     */
    fun handle(target: T, with: H): Boolean
}
