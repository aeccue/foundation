package com.aeccue.foundation.text.validator

import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class StringValidatorsTest {

    @ParameterizedTest
    @MethodSource(StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES)
    fun `validates valid String with AlphaStringValidator`(target: String) {
        AlphaStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates invalid String with AlphaStringValidator`(target: String) {
        AlphaStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES)
    fun `validates valid String with AlphaNumericStringValidator`(target: String) {
        AlphaNumericStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates invalid String with AlphaNumericStringValidator`(target: String) {
        AlphaNumericStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates valid String with AlphaNumericSpaceStringValidator`(target: String) {
        AlphaNumericSpaceStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES)
    fun `validates invalid String with AlphaNumericSpaceStringValidator`(target: String) {
        AlphaNumericSpaceStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES)
    fun `validates valid String with AlphaSpaceStringValidator`(target: String) {
        AlphaSpaceStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates invalid String with AlphaSpacesStringValidator`(target: String) {
        AlphaSpaceStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES)
    fun `validates valid String with EmailStringValidator`(target: String) {
        EmailStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates invalid String with EmailStringValidator`(target: String) {
        EmailStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES)
    fun `validates valid String with NumericStringValidator`(target: String) {
        NumericStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates invalid String with NumericStringValidator`(target: String) {
        NumericStringValidator.validate(target).`should be false`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_SPACE_SUCCESS_TEST_CASES)
    fun `validates valid String with NumericSpaceStringValidator`(target: String) {
        NumericSpaceStringValidator.validate(target).`should be true`()
    }

    @ParameterizedTest
    @MethodSource(
            StringValidatorTestCases.ALPHA_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_FAIL_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_NUMERIC_SPACE_SUCCESS_TEST_CASES,
            StringValidatorTestCases.ALPHA_SPACE_FAIL_TEST_CASES,
            StringValidatorTestCases.EMAIL_SUCCESS_TEST_CASES,
            StringValidatorTestCases.NUMERIC_FAIL_TEST_CASES)
    fun `validates invalid String with NumericSpaceStringValidator`(target: String) {
        NumericSpaceStringValidator.validate(target).`should be false`()
    }
}
