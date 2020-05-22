package subtask2

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val first = array[0]
        val second = array[1]
        for (n in 0..(second/2)){
            if (first * factorialFun(n) * factorialFun(second - n) == factorialFun(second)){
                return n
            }
        }
        return null
    }
    private fun factorialFun (i:Int):Int{
        if ((i == 0) or (i == 1)) return 1
        var factorial = 1
        for(j in 1..i){
            factorial *= j
        }
        return factorial
    }
}
