package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {


    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        var result = ""
        val coef = numbers.size - 1
        for (n in numbers.indices) {
            if (numbers[n] == 0) {
                result += ""
            } else if (numbers[n] == -1) {
                result += " - " + "x"
            } else if (numbers[n] == 1) {
                result += " + " + "x"
            } else if (numbers[n] > 0) {
                if (n == coef) {
                    result += " + " + numbers[n].absoluteValue.toString()
                } else if (n == coef - 1) {
                    result += " + " + numbers[n].absoluteValue.toString() + "x"
                } else if (numbers[n] == numbers.first()) {
                    result += numbers[n].absoluteValue.toString() + "x^" + (coef).toString()
                } else {
                    result += " + " + numbers[n].absoluteValue.toString() + "x^" + (coef - n).toString()
                }
            } else if (numbers[n] < 0) {
                result += " - " + numbers[n].absoluteValue.toString() + "x^" + (coef - n).toString()
            }

        }
        return result
    }
}
