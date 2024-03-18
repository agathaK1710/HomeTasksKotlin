package org.example

fun List<Any>.findIntOrNull() = firstOrNull {
    it as? Int != null
} as? Int

fun main() {
    val list: List<Any> = listOf(1.0, "android", 3.2, 'p', 21f, 15L, 10)
    println(list.findIntOrNull())
}