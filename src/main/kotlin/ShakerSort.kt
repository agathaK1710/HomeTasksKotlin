package org.example

private operator fun Int?.compareTo(i: Int?): Int {
    return if (this != null && i != null) {
        this - i
    } else {
        0
    }
}

fun shakerSort(list: List<Int?>): List<Int?> {
    val result = ArrayList(list)
    var start = 0
    var end = list.size - 1
    if(result.firstOrNull{it != null} == null) return result
    while (start < end) {
        for (i in start until end) {
            if (result[i] == null || result[i] > result[i + 1]) {
                result.swap(i, i + 1)
            }
        }
        end--
        for (i in end downTo start + 1) {
            if (result[i - 1] == null || result[i - 1] > result[i]) {
                result.swap(i - 1, i)
            }
        }
        start++
    }
    return result
}

fun ArrayList<Int?>.swap(index1: Int, index2: Int) {
    val value1 = this[index1]
    this[index1] = this[index2]
    this[index2] = value1
}

fun main() {
    val list = listOf(1, 7, null, 5, 3, 75, 2, 1, null, 15)
    val listOfNull = listOf(null, null, null)
    println(shakerSort(list))
    println(shakerSort(listOfNull))
}