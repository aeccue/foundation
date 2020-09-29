package com.aeccue.foundation.text.validator

import java.util.stream.Stream

@Suppress("unused")
object StringValidatorTestCases {

    private const val fullyQualifiedName = "com.aeccue.foundation.text.validator.StringValidatorTestCases"

    const val ALPHA_SUCCESS_TEST_CASES = "$fullyQualifiedName#alphaSuccessTestCases"
    const val ALPHA_FAIL_TEST_CASES = "$fullyQualifiedName#alphaFailTestCases"
    const val ALPHA_NUMERIC_SUCCESS_TEST_CASES = "$fullyQualifiedName#alphaNumericSuccessTestCases"
    const val ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES = "$fullyQualifiedName#alphaNumericSpaceSuccessTestCases"
    const val ALPHA_SPACE_SUCCESS_TEST_CASES = "$fullyQualifiedName#alphaSpaceSuccessTestCases"
    const val ALPHA_SPACE_FAIL_TEST_CASES = "$fullyQualifiedName#alphaSpaceFailTestCases"
    const val EMAIL_SUCCESS_TEST_CASES = "$fullyQualifiedName#emailSuccessTestCases"
    const val NUMERIC_SUCCESS_TEST_CASES = "$fullyQualifiedName#numericSuccessTestCases"
    const val NUMERIC_FAIL_TEST_CASES = "$fullyQualifiedName#numericFailTestCases"
    const val NUMERIC_SPACE_SUCCESS_TEST_CASES = "$fullyQualifiedName#numericSpaceSuccessTestCases"

    @JvmStatic
    fun alphaSuccessTestCases(): Stream<String> = Stream.of(
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "AbCdEfGhIjKlMnOpQrStUvWxYz"
    )

    @JvmStatic
    fun alphaFailTestCases(): Stream<String> = Stream.of(
            "xÿz",
            "ThisStringContainsSpecialCharacters!@#$@%^&*()"
    )

    @JvmStatic
    fun alphaNumericSuccessTestCases(): Stream<String> = Stream.of(
            "abcdefghijklmnopqrstuvwxyz0123456789",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",
            "aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789"
    )

    @JvmStatic
    fun alphaNumericSpaceSuccessTestCases(): Stream<String> = Stream.of(
            "abcdefg 123456",
            "This String contains the number 1"
    )

    @JvmStatic
    fun alphaSpaceSuccessTestCases(): Stream<String> = Stream.of(
            "This String contains spaces",
            " This String also contains Space",
            "  "
    )

    @JvmStatic
    fun alphaSpaceFailTestCases(): Stream<String> = Stream.of(
            "This is invalid ÿ",
            "This is invalid ０"
    )

    @JvmStatic
    fun emailSuccessTestCases(): Stream<String> = Stream.of(
            "hello@world.com"
    )

    @JvmStatic
    fun numericSuccessTestCases(): Stream<String> = Stream.of(
            "0123456789"
    )

    @JvmStatic
    fun numericFailTestCases(): Stream<String> = Stream.of(
            "０123"
    )

    @JvmStatic
    fun numericSpaceSuccessTestCases(): Stream<String> = Stream.of(
            "01234 56789",
            "10 11 12 13 14 15 16 17 18 19"
    )
}
