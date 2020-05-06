package subtask4
import kotlin.math.floor
import kotlin.math.sqrt
class SquareDecomposer {


    fun decomposeNumber(number: Int): Array<Int>? {
        return taskLogic(number * number, number -1)?.toTypedArray()
    }
    private fun taskLogic(input: Int, value: Int): ArrayList<Int>?{
        for (i in value downTo 1){
            var square = i * i
            var counter = input - square
            if (counter == 0) {
                return arrayListOf(i)
            }
            if (counter < 0){
                return null
            }
            var square2 = floor(sqrt(counter.toDouble())).toInt()
            if (square2 >= i){
                square2 = i - 1
            }
            val taskValue = taskLogic(counter, square2)
            if (taskValue != null){
                taskValue.add(i)
                return taskValue
            }
        }
        return null
    }
}
