package com.aeccue.foundation

/**
 * An interface that dictates that the implementing class is capable of handling an object of class
 * [T] using an object of class [H].
 *
 * @param [T] The class to handle.
 * @param [H] The class to use for handling.
 */
interface Handler<in T, in H> {

    /**
     * Handles a target.
     *
     * @param [target] The target to handle.
     * @param [with] What to use for handling.
     */
    fun handle(target: T, with: H)
}
