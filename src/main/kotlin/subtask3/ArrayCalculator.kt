package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {


    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var itemsInt =itemsFromArray.filterIsInstance<Int>()
        var productItems = itemsInt.sortedBy { it.absoluteValue }.reversed()
        var result = 1
        if (productItems.isEmpty()){
            return 0
        }
        if (productItems.size <= numberOfItems){
            for (i in productItems){
                result*=i
            }
            return result
        }
        val positiveItem = productItems.filter { it -> it >=0 }
        var positiveResult = 1
        for (i in 0 until numberOfItems){
            result*=productItems[i]
        }
        for (i in 0 until numberOfItems){
            positiveResult *= positiveItem[i]
        }

        if (positiveResult > result){
            return positiveResult
        }
        return result
    }
}
