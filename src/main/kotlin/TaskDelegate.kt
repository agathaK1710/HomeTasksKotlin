package org.example

import kotlinx.coroutines.*
import java.time.LocalDateTime
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private fun myDelegate(): ReadWriteProperty<Any?, LocalDateTime> = object : ReadWriteProperty<Any?, LocalDateTime> {
    lateinit var currentTime: LocalDateTime
    val scope = CoroutineScope(Dispatchers.IO)

    override fun getValue(thisRef: Any?, property: KProperty<*>): LocalDateTime {
        return currentTime
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: LocalDateTime) {
        currentTime = value
//        thread(start = true) {
//            while (true) {
//                println(currentTime)
//                Thread.sleep(3000)
//            }
//        }
        scope.launch {
            while (true) {
                println(currentTime)
               delay(3000)
            }
        }
    }

}


fun main() {
    var currentTime: LocalDateTime by myDelegate()
    currentTime = LocalDateTime.now()
    Thread.sleep(10000)
}


