package com.aeccue.foundation.test

/**
 * A test case that has one input and one expected output.
 *
 * @param [I] The class of the input.
 * @param [O] The class of the output.
 * @property [input] The input for this test case.
 * @property [output] The expected output for this test case.
 */
data class IOTestCase<out I, out O>(val input: I, val output: O)
