package chapter2



fun main(){
//    recurEx1(5)
//    recurSumEx2(listOf(1,2,3,4),3)
//    americano(10)
    ninevs6(listOf(1,2,3,4),3,0,4)
}

/**
 * key point
 * 1.함수를 호출하는 경우 메모리에 누적
 * **/
fun recurEx1(value:Int){
    if (value ==0) return
    recurEx1(value-1)
    println(value)
    // 함수 스왑에 따라 스택 구조가 바뀌니까 당연하게 출력 결과 변경
}

fun recurSumEx2(arr:List<Int>, idx:Int):Int{
    if (idx<0) return 0
    val res = recurSumEx2(arr,idx-1) + arr[idx]
    println(res)
    return res
    // => 메모리 낭비
}
fun americano(idx:Int):Int{
    if (idx<=1) return idx
    val res = americano(idx-1)+ americano(idx-2)
    println(res)
    return res
}

fun ninevs6(arr: List<Int>, findRes: Int, start: Int, end: Int): Int {
    if (start > end) return -1
    val mid = start + (end - start) / 2
    return when {
        arr[mid] < findRes -> ninevs6(arr, findRes, mid + 1, end)
        arr[mid] > findRes -> ninevs6(arr, findRes, start, mid - 1)
        arr[mid] == findRes -> {
            println(mid)
            mid
        }
        else -> -1
    }
}