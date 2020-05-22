package subtask6

class FullBinaryTrees {


    data class Row (var count: Int, var perent: Row?, var value: Array<String> = arrayOf())

    fun stringForNodeCount(count: Int): String {
        if (1 > count){
            return "[]"
        }
        if (0 == count%2){
            return "[]"
        }
        val root = Row(count - 1, null, arrayOf("0"))
        val kinds = findChildren(root)
        var result: Array<String> = arrayOf()
        for (k in kinds){
            var row: Array<String> = arrayOf()
            var node:Row? = k
            while (null != node){
                row = node.value + row
                node = node.perent
            }
            result += arrayOf("[" + row.joinToString (",") + "]")
            result.forEach { println("result ${it}") }
        }
        return "[" + result.joinToString(" ") + "]"
    }

    private fun findChildren (root: Row): Array<Row>{
        val count = root.count
        if (0 == count){
            return arrayOf(Row(0, root , arrayOf()))
        }
        val rowValue = root.value
        val rowSize = rowValue.size - 1
        println(rowSize)
        var resultRow: Array<Row> = arrayOf()
        for (i in 0..rowSize){
            if ("0" == rowValue[i]){
                if (resultRow.isEmpty()){
                    resultRow += arrayOf(Row(count, root)) + arrayOf(Row(count, root))
                } else {
                    resultRow = duplicateRow(resultRow)
                }
                for (j in 0 until resultRow.size/2){
                    println("result row size: ${resultRow.size}")
                    if ( 1 < resultRow[j*2].count){
                        resultRow[j*2].value += arrayOf("0", "0")
                        resultRow[j*2].count -= 2
                        resultRow[j*2 + 1].value += arrayOf("null", "null")
                    }
                }
            }
        }
        var withChild: Array<Row> = arrayOf()
        for (rez in resultRow){
            if (2 > rez.count){
                if (rez.value.isNotEmpty()){
                    withChild += rez
                }
            } else {
                withChild += findChildren(rez)
            }
        }
        return withChild
    }

    private fun duplicateRow(rowArray: Array<Row>): Array<Row>{
        var newRow = arrayOf<Row>()
        for (r in rowArray){
            newRow += r
            if (0 == r.count){
                newRow += Row(r.count, r.perent, arrayOf())
            } else {
                newRow += Row(r.count, r.perent, r.value)
            }
        }
        return newRow
    }
}
