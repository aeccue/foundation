package com.aeccue.foundation.response.error

/**
 * An [InternalError] returned when there is a possible cyberattack and should be logged for further
 * investigation.
 *
 * @property [attack] The attack that was detected.
 */
interface CyberAttackError : InternalError {

    val attack: String

    override val error get() = attack
}
