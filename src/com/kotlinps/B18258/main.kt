package com.kotlinps.B18258

import java.io.BufferedWriter
import java.util.LinkedList
import java.util.Queue

val queue: Queue<Int> = LinkedList()
var lastElement = 0
var customSize = 0
val bw = BufferedWriter(System.out.bufferedWriter())

fun Queue<Int>.customOffer(string: String) {
    val value = string.split(" ")[1].toInt()
    this.offer(value)
    lastElement = value
    customSize++
}

fun Queue<Int>.customPop() {
    if (this.isEmpty())
        bw.write("-1\n")
    else {
        bw.write("${this.poll()}\n")
        customSize--
    }
}
fun customSize() = bw.write("$customSize\n")
fun Queue<Int>.customIsEmpty() = if (this.isEmpty()) bw.write("1\n") else bw.write("0\n")
fun Queue<Int>.customFront() = if (this.isEmpty()) bw.write("-1\n") else bw.write("${this.peek()}\n")
fun Queue<Int>.customBack() = if (this.isEmpty()) bw.write("-1\n") else bw.write("$lastElement\n")

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    for (i in 1..count) {
        val command = readLine()
        if (command.contains("push")) {
            queue.customOffer(command)
            continue
        }
        when (command) {
            "pop" -> queue.customPop()
            "size" -> customSize()
            "empty" -> queue.customIsEmpty()
            "front" -> queue.customFront()
            "back" -> queue.customBack()
        }
    }
    bw.flush()
}