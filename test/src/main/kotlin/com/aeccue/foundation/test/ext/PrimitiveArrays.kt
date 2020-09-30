package com.aeccue.foundation.test.ext

import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEqualTo

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun BooleanArray?.contentsShouldBeEqualTo(expected: BooleanArray?): Array<Boolean>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun BooleanArray?.`contents should be equal to`(expected: BooleanArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun BooleanArray?.contentsShouldNotBeEqualTo(expected: BooleanArray?): Array<Boolean>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun BooleanArray?.`contents should not be equal to`(expected: BooleanArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun ByteArray?.contentsShouldBeEqualTo(expected: ByteArray?): Array<Byte>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun ByteArray?.`contents should be equal to`(expected: ByteArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun ByteArray?.contentsShouldNotBeEqualTo(expected: ByteArray?): Array<Byte>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun ByteArray?.`contents should not be equal to`(expected: ByteArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun CharArray?.contentsShouldBeEqualTo(expected: CharArray?): Array<Char>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun CharArray?.`contents should be equal to`(expected: CharArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun CharArray?.contentsShouldNotBeEqualTo(expected: CharArray?): Array<Char>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun CharArray?.`contents should not be equal to`(expected: CharArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun DoubleArray?.contentsShouldBeEqualTo(expected: DoubleArray?): Array<Double>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun DoubleArray?.`contents should be equal to`(expected: DoubleArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun DoubleArray?.contentsShouldNotBeEqualTo(expected: DoubleArray?): Array<Double>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun DoubleArray?.`contents should not be equal to`(expected: DoubleArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun FloatArray?.contentsShouldBeEqualTo(expected: FloatArray?): Array<Float>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun FloatArray?.`contents should be equal to`(expected: FloatArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun FloatArray?.contentsShouldNotBeEqualTo(expected: FloatArray?): Array<Float>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun FloatArray?.`contents should not be equal to`(expected: FloatArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun IntArray?.contentsShouldBeEqualTo(expected: IntArray?): Array<Int>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun IntArray?.`contents should be equal to`(expected: IntArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun IntArray?.contentsShouldNotBeEqualTo(expected: IntArray?): Array<Int>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun IntArray?.`contents should not be equal to`(expected: IntArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun LongArray?.contentsShouldBeEqualTo(expected: LongArray?): Array<Long>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun LongArray?.`contents should be equal to`(expected: LongArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun LongArray?.contentsShouldNotBeEqualTo(expected: LongArray?): Array<Long>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun LongArray?.`contents should not be equal to`(expected: LongArray?) =
        this.contentsShouldNotBeEqualTo(expected)

/**
 * Asserts that the contents of this array is equivalent to the contents of another array. The test
 * will fail if the contents are not equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun ShortArray?.contentsShouldBeEqualTo(expected: ShortArray?): Array<Short>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun ShortArray?.`contents should be equal to`(expected: ShortArray?) =
        this.contentsShouldBeEqualTo(expected)

/**
 * Asserts that the contents of this array is not equivalent to the contents of another array. The
 * test will fail if the contents are equal.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
infix fun ShortArray?.contentsShouldNotBeEqualTo(expected: ShortArray?): Array<Short>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

/**
 * Same as [contentsShouldNotBeEqualTo], but with spaces in the function name to be more expressive.
 *
 * @param [expected] The array to compare.
 * @return This array.
 */
@Suppress("FunctionName")
infix fun ShortArray?.`contents should not be equal to`(expected: ShortArray?) =
        this.contentsShouldNotBeEqualTo(expected)
