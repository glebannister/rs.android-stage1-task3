package subtask3

import kotlin.math.absoluteValue


 class ArrayCalculator {



    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val itemsInt = itemsFromArray.filterIsInstance<Int>()
        val productItems = itemsInt.sortedBy { it.absoluteValue }.reversed()
        var result = 1
        if (productItems.isEmpty()){
            return 0
        }
        if (productItems.size <= numberOfItems){
            for (i in productItems){
                result *= i
            }
            return result
        }
        for (i in 0 until numberOfItems){
            result *= productItems[i]
        }
        val positiveResult:Int = countPositiveResult(numberOfItems, itemsFromArray)
        if (positiveResult > result){
            return positiveResult
        }
        return result
    }
    private fun countPositiveResult (numberOfItems: Int, itemsFromArray: Array<Any>) : Int{
        val itemsInt = itemsFromArray.filterIsInstance<Int>()
        val productItems = itemsInt.sortedBy { it.absoluteValue }.reversed()
        val positiveItem = productItems.filter { it >= 0 }
        var result = 1
        for (i in 0 until numberOfItems){
            result *= positiveItem[i]
        }
        return result
    }
}
