package cl.talentodigital.aves.utils.validator

object NumberValidator {
    fun validate(number: String): Boolean {
        return number.isNotEmpty() && number.matches("^(\\(?\\+?[0-9]*\\)?)?[0-9_\\-()]*\$".toRegex())
    }
}