package cl.talentodigital.aves.utils.validator

object PassValidator {

    const val PASSWORD_VALUES = ".{4,16}"

    fun validate(password: String): Boolean {
        return password.isNotEmpty() && password.matches(PASSWORD_VALUES.toRegex())
    }
}