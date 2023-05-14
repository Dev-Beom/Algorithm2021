package com.kotlinps.new

import java.util.PriorityQueue

//Q) input값이 큰 순서대로 랭킹을 산정해주세요. (단, 값이 같으면 동일 순위로 표기합니다.)
//```
//- input : [98, 98, 50, 100, 30, 90]
//- output : [2, 2, 5, 1, 6, 4]
//```

class Node(val id: Int, val data: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = other.data - data
}

fun getNodeRanks(nodes: List<Node>): List<Int> {
    val priorityQueue = PriorityQueue<Node>()
    val dataTable = mutableMapOf<Int, Int>()
    priorityQueue.addAll(nodes)
    var rank = 0
    var sameDataCount = 0
    var prevNode: Node? = null
    while (priorityQueue.isNotEmpty()) {
        val currNode = priorityQueue.poll()
        if (prevNode == null || prevNode.data != currNode.data) {
            dataTable[currNode.id] = ++rank + sameDataCount
            rank += sameDataCount
            sameDataCount = 0
        } else {
            dataTable[currNode.id] = rank
            sameDataCount++
        }
        prevNode = currNode
    }
    return nodes.map { e -> dataTable[e.id]!! }
}

fun List<Int>.toNode(): List<Node> {
    var idx = 0
    return this.map { e -> Node(idx++, e) }
}

fun process(input: List<Int>): List<Int> = getNodeRanks(input.toNode())

fun assert(a: List<Int>, b: List<Int>): Boolean = a == b

fun main() {
    // given
    val input = listOf(98, 98, 50, 100, 30, 90)
    val output = listOf(2, 2, 5, 1, 6, 4)

    assert(process(input), output).let { println(it) }
}