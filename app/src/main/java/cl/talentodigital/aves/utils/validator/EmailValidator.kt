package cl.talentodigital.aves.utils.validator

import java.util.regex.Matcher
import java.util.regex.Pattern

object EmailValidator {
    private const val REGEX_VALUE =
        "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"

    fun validate(email: String): Boolean {
        if (email.isEmpty()) return false
        val pattern: Pattern = Pattern.compile(REGEX_VALUE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}