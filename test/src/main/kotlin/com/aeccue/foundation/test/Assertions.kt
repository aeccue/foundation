package com.aeccue.foundation.test

import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEqualTo

infix fun BooleanArray?.contentsShouldBeEqualTo(expected: BooleanArray?): Array<Boolean>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun BooleanArray?.`contents should be equal to`(expected: BooleanArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun BooleanArray?.contentsShouldNotBeEqualTo(expected: BooleanArray?): Array<Boolean>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun BooleanArray?.`contents should not be equal to`(expected: BooleanArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun ByteArray?.contentsShouldBeEqualTo(expected: ByteArray?): Array<Byte>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun ByteArray?.`contents should be equal to`(expected: ByteArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun ByteArray?.contentsShouldNotBeEqualTo(expected: ByteArray?): Array<Byte>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun ByteArray?.`contents should not be equal to`(expected: ByteArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun CharArray?.contentsShouldBeEqualTo(expected: CharArray?): Array<Char>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun CharArray?.`contents should be equal to`(expected: CharArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun CharArray?.contentsShouldNotBeEqualTo(expected: CharArray?): Array<Char>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun CharArray?.`contents should not be equal to`(expected: CharArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun DoubleArray?.contentsShouldBeEqualTo(expected: DoubleArray?): Array<Double>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun DoubleArray?.`contents should be equal to`(expected: DoubleArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun DoubleArray?.contentsShouldNotBeEqualTo(expected: DoubleArray?): Array<Double>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun DoubleArray?.`contents should not be equal to`(expected: DoubleArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun FloatArray?.contentsShouldBeEqualTo(expected: FloatArray?): Array<Float>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun FloatArray?.`contents should be equal to`(expected: FloatArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun FloatArray?.contentsShouldNotBeEqualTo(expected: FloatArray?): Array<Float>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun FloatArray?.`contents should not be equal to`(expected: FloatArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun IntArray?.contentsShouldBeEqualTo(expected: IntArray?): Array<Int>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun IntArray?.`contents should be equal to`(expected: IntArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun IntArray?.contentsShouldNotBeEqualTo(expected: IntArray?): Array<Int>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun IntArray?.`contents should not be equal to`(expected: IntArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun LongArray?.contentsShouldBeEqualTo(expected: LongArray?): Array<Long>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun LongArray?.`contents should be equal to`(expected: LongArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun LongArray?.contentsShouldNotBeEqualTo(expected: LongArray?): Array<Long>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun LongArray?.`contents should not be equal to`(expected: LongArray?) =
        this.contentsShouldNotBeEqualTo(expected)

infix fun ShortArray?.contentsShouldBeEqualTo(expected: ShortArray?): Array<Short>? =
        this?.toTypedArray()?.shouldBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun ShortArray?.`contents should be equal to`(expected: ShortArray?) =
        this.contentsShouldBeEqualTo(expected)

infix fun ShortArray?.contentsShouldNotBeEqualTo(expected: ShortArray?): Array<Short>? =
        this?.toTypedArray()?.shouldNotBeEqualTo(expected?.toTypedArray())

@Suppress("FunctionName")
infix fun ShortArray?.`contents should not be equal to`(expected: ShortArray?) =
        this.contentsShouldNotBeEqualTo(expected)
