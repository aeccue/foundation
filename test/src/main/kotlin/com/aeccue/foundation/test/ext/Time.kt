package com.aeccue.foundation.test.ext

import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset

fun Long.toClock(): Clock = Clock.fixed(toInstant(), ZoneOffset.UTC)

fun Long.toInstant(): Instant = Instant.ofEpochMilli(this)
