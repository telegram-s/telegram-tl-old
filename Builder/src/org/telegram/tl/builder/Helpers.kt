package org.telegram.tl.builder

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 23.10.13
 * Time: 8:49
 */
fun hex(value: Int) = Integer.toHexString(value)

fun uCamelCase(value: String) = if (value[0].isUpperCase())
    value
else
    value[0].toString().toUpperCase() + value.substring(1)

fun lCamelCase(value: String) = if (!value[0].isUpperCase())
    value
else
    value[0].toString().toLowerCase() + value.substring(1)