package com.example.hhtestapp

object Validator {

    @JvmStatic
    fun isEmailValid(email: String): Boolean
            = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    @JvmStatic
    fun hasSymbol(data: String): Boolean =
        !data.matches("[A-Za-z0-9 ]*".toRegex())

    @JvmStatic
    fun hasDigit(data: String): Boolean =
        data.matches(".*\\d.*".toRegex())

    @JvmStatic
    fun hasUpperCase(data: String): Boolean =
        data != data.toLowerCase()

    @JvmStatic
    fun hasLowerCase(data: String): Boolean =
        data != data.toUpperCase()

}