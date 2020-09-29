package com.aeccue.foundation.collection.ext

/**
 * Checks if this set contains an element, ignoring character case.
 *
 * @param [element] The element to compare.
 * @return True if this set contains element, disregarding character case, false otherwise
 */
fun Set<String>.containsIgnoreCase(element: String): Boolean {
    for (s in this) {
        if (s.equals(element, true)) return true
    }

    return false
}

/**
 * Converts all Strings in this set to lower case.
 *
 * @return A copy of this set with all Strings in lower case.
 */
fun Set<String>.toLowerCase(): Set<String> = map { it.toLowerCase() }.toSet()
