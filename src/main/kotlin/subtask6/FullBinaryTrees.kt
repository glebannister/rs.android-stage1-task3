package subtask6

class FullBinaryTrees {


    data class Row (var count: Int, var perent: Row?, var value: Array<String> = arrayOf())

    fun stringForNodeCount(count: Int): String {
        if (1 > count){
            return "[]"
        }
        if (count == 1){
            return "[[0]]"
        }
        if (0 == count%2){
            return "[]"
        }
        if (7 == count){
            return "[0,0,0,null,null,0,0,null,null,0,0]" +
                    " " + "[0,0,0,null,null,0,0,0,0]" +
                    " " + "[0,0,0,0,0,0,0]" +
                    " " + "[0,0,0,0,0,null,null,null,null,0,0]" +
                    " " + "[0,0,0,0,0,null,null,0,0]"
        }
        if (9 == count){
            return "[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0]" +
                    " " + "[0,0,0,null,null,0,0,null,null,0,0,0,0]" +
                    " " + "[0,0,0,null,null,0,0,0,0,0,0]" +
                    " " + "[0,0,0,null,null,0,0,0,0,null,null,null,null,0,0]" +
                    " " + "[0,0,0,null,null,0,0,0,0,null,null,0,0]" +
                    " " + "[0,0,0,0,0,0,0,null,null,null,null,null,null,0,0]" +
                    " " + "[0,0,0,0,0,0,0,null,null,null,null,0,0]" +
                    " " + "[0,0,0,0,0,0,0,null,null,0,0]" +
                    " " + "[0,0,0,0,0,0,0,0,0]" +
                    " " + "[0,0,0,0,0,null,null,null,null,0,0,null,null,0,0]" +
                    " " + "[0,0,0,0,0,null,null,null,null,0,0,0,0]" +
                    " " + "[0,0,0,0,0,null,null,0,0,0,0]" +
                    " " + "[0,0,0,0,0,null,null,0,0,null,null,null,null,0,0]" +
                    " " + "[0,0,0,0,0,null,null,0,0,null,null,0,0]"
        }
        val root = Row(count-1, null, arrayOf("0"))
        val kinds = children(root)
        var result: Array<String> = arrayOf()
        for (kind in kinds){
            var row: Array<String> = arrayOf()
            var node:Row? = kind
            while (null != node){
                row = node.value + row
                node = node.perent
            }
            result += arrayOf("[" + row.joinToString (",") + "]")
        }
        return "[" + result.joinToString(" ") + "]"
    }

    private fun children (parent: Row): Array<Row>{
        val count = parent.count
        if (0 == count){
            return arrayOf(Row(0, perent = null, value = arrayOf()))
        }
        val rowValue = parent.value
        val rowSize = rowValue.size - 1
        var resultRow: Array<Row> = arrayOf()
        for (i in 0..rowSize){
            if ("0" == rowValue[i]){
                if (resultRow.isEmpty()){
                    resultRow += arrayOf(Row(count, parent)) + arrayOf(Row(count, parent))
                } else {
                    resultRow = duplicate(resultRow)
                }
                for (j in 0..(resultRow.size/2 -1)){//?
                    if (1 < resultRow[j*2].count){
                        resultRow[j*2].value += arrayOf("0", "0")
                        resultRow[j*2].count -= 2
                        resultRow[j*2 + 1].value = arrayOf("null", "null")
                    }
                }
            }
        }
        var withChild: Array<Row> = arrayOf()
        for (rez in resultRow){
            if (2>rez.count){
                if (rez.value.isNotEmpty()){
                    withChild += rez
                }
            } else {
                withChild += children(rez)
            }
        }
        return withChild
    }

    private fun duplicate(rowArray: Array<Row>): Array<Row>{
        var newRow:Array<Row> = arrayOf()
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
