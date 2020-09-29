package com.aeccue.foundation.io.ext

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import org.json.simple.parser.ParseException.ERROR_UNEXPECTED_EXCEPTION
import java.io.Reader

/**
 * Attempts to parse this character stream into a JSONObject.
 *
 * @return The parsed JSONObject if successful.
 * @throws [ParseException] If character stream cannot be parsed into a JSONObject.
 */
fun Reader.readJSONObject(): JSONObject = (JSONParser().parse(this) as? JSONObject)
        ?: throw ParseException(ERROR_UNEXPECTED_EXCEPTION)
