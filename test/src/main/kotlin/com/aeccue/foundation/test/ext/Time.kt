package com.aeccue.foundation.test.ext

import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset

/**
 * Converts this Long to a Clock with its Instant set to this, in UTC.
 *
 * @return The Clock created from this Long.
 */
fun Long.toClock(): Clock = Clock.fixed(toInstant(), ZoneOffset.UTC)

/**
 * Converts this Long to an Instant with its epoch millisecond set to this.
 *
 * @return The Instant created from this Long.
 */
fun Long.toInstant(): Instant = Instant.ofEpochMilli(this)
