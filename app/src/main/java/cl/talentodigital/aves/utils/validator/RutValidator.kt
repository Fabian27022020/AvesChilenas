package cl.talentodigital.aves.utils.validator

import cl.talentodigital.aves.utils.ConstantValues.EMPTY_STRING
import cl.talentodigital.aves.utils.ConstantValues.POINT_VALUE
import cl.talentodigital.aves.utils.ConstantValues.RUT_SEPARATOR
import java.util.*

import java.util.regex.Matcher
import java.util.regex.Pattern

object RutValidator {

    private const val PATTERN = "[.-]"

    private fun validate(rut: Int, dv: Char): Boolean {
        var rutAux = rut
        var m = 0
        var s = 1
        while (rutAux != 0) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11
            rutAux /= 10
        }
        return dv == (if (s != 0) s + 47 else 75).toChar()
    }

    fun validate(rut: String): Boolean {
        if (rut.isEmpty()) return false
        val numberString =
            rut.substring(0, rut.length - 1)
                .replace(RUT_SEPARATOR, EMPTY_STRING)
                .replace(POINT_VALUE, EMPTY_STRING)
        val dv = rut.toUpperCase(Locale.ROOT)[rut.length - 1]
        val number: Int
        number = try {
            numberString.toInt()
        } catch (e: Exception) {
            return false
        }
        return validate(number, dv)
    }

    fun compareRut(rut1: CharSequence, rut2: CharSequence): Boolean {
        val pattern: Pattern = Pattern.compile(PATTERN)
        val m1: Matcher = pattern.matcher(rut1)
        val m2: Matcher = pattern.matcher(rut2)
        return m1.replaceAll(EMPTY_STRING) == m2.replaceAll(EMPTY_STRING)
    }
}