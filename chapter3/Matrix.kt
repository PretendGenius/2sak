package chapter3

/*
* 동적
*
**/

fun main(args: Array<String>) {
    val matrix = MatrixImpl(Array(5) { FloatArray(5) })

    matrix.setValue(0, 0, 1.0f)
    matrix.setValue(1, 2, 2.0f)
    matrix.setValue(2, 4, 3.0f)
    matrix.setValue(3, 1, 4.0f)
    matrix.printMatrix()
    val addMatrix = MatrixImpl(Array(4) { FloatArray(6) { 1.0f } })
    matrix.add(addMatrix)
    matrix.printMatrix()
    matrix.transpose(matrix)
    matrix.printMatrix()
}
abstract class Matrix {
    abstract fun matrix(matrix: Array<IntArray>): Array<IntArray>
    abstract fun setValue(row:Int,Column:Int,value:Float)
    abstract fun getValue(row:Int,column:Int):Float
    abstract fun add(matrix: Matrix)
    abstract fun transpose(matrix: Matrix)
    abstract fun printMatrix()
}
class MatrixImpl(private val matrix: Array<FloatArray>) : Matrix() {
    override fun matrix(matrix: Array<IntArray>): Array<IntArray> {
      val resMatrix = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                matrix[i][j] = matrix[i][j] + matrix[i][j]
            }
        }
        return resMatrix
    }

    override fun setValue(row: Int, Column: Int, value: Float) {
            matrix[row][Column] = value
    }

    override fun getValue(row: Int, column: Int): Float {
        return matrix[row][column]
    }

    override fun add(matrixParam: Matrix) {
        for (i in matrix.indices){
            for (j in matrix[i].indices){
                matrix[i][j] += matrixParam.getValue(i, j)
            }
        }
    }

    override fun transpose(matrixParam: Matrix) {
        val row = matrix.size
        val col = matrix[0].size
        val temp =Array(col){FloatArray(row)}
        for (i in matrix.indices){
            for (j in matrix[0].indices){
                temp[i][j] += matrixParam.getValue(i, j)
            }
        }
        for (i in temp.indices){
            for (j in temp[0].indices){
                matrix[i][j] += temp[i][j]
            }
        }
    }

    override fun printMatrix() {
        for (i in matrix.indices ){
            println(matrix[i].joinToString(" "))
        }
    }
}