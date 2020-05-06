package subtask2

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val zero = array[0]
        val one = array[1]
        for (n in 0..(one/2)){
            if (zero*factorial(n)*factorial(one-n) == factorial(one)){
                return n
            }
        }
        return null
    }
    private fun factorial (i:Int):Int{
        if ((i == 0) or (i == 1)) return 1
        var factorl = 1
        for(j in 1..i){
            factorl*=j
        }
        return factorl
    }
}
