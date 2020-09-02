package cl.talentodigital.aves.utils.validator

import java.util.*

object NameValidator {
    private const val REGEX_VALUE = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
    fun validate(name: String): Boolean {
        return validateCountNames(name) && name.matches(REGEX_VALUE.toRegex())
    }

    private fun validateCountNames(name: String): Boolean {
        return StringTokenizer(name).countTokens() > 1
    }
}