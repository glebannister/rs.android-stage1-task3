package subtask5


class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val numberCouples = mapOf(
            '0' to arrayOf("8"),
            '1' to arrayOf("2","4"),
            '2' to arrayOf("1", "3", "5"),
            '3' to arrayOf("2", "6"),
            '4' to arrayOf("1", "5", "7"),
            '5' to arrayOf("2", "4", "6", "8"),
            '6' to arrayOf("3", "5", "9"),
            '7' to arrayOf("4", "8"),
            '8' to arrayOf("5", "7", "9", "0"),
            '9' to arrayOf("6", "8"))
        val result = mutableListOf<String>()
        for (i in number.indices){
            val forReplace = number[i]
            if (number[i].equals('-')){
                return null
            }
                for (j in numberCouples.getValue(forReplace)) {
                    result.add(number.substring(0, i) + j + number.substring(i + 1, number.length))
                }
        }
        return result.toTypedArray()
    }
}
