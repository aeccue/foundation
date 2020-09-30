package com.aeccue.foundation.response.error.internal

/**
 * An [InternalError] returned when there is a possible cyberattack and should be logged for further
 * investigation.
 *
 * @property [tag] The tag of the class in which this error occurred.
 * @property [method] The name of the method in which this error occured.
 * @property [attack] The attack that was detected.
 * @property [cause] An optional cause for this error.
 */
class CyberAttackError(override val tag: String,
                       override val method: String,
                       val attack: String,
                       override val cause: Throwable? = null)
    : InternalError(tag, method, attack, cause)
