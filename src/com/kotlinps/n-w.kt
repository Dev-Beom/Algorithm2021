package com.kotlinps

//Q) input값이 큰 순서대로 랭킹을 산정해주세요. (단, 값이 같으면 동일 순위로 표기합니다.)
//```
//- input : [98, 98, 50, 100, 30, 90]
//- output : [2, 2, 5, 1, 6, 4]
//```

fun List<Int>.toString2(): String {
    var str = ""
    for (el in this) {
        str += el
    }
    return str
}

fun rankLogic(input: List<Int>): MutableList<Int> {
    var output = mutableListOf<Int>()
    for (i in 0..input.size - 1) {
        output.add(input.filter { it > input[i] }.size + 1)
    }
    return output
}

fun assert(a: List<Int>, b: List<Int>): Boolean {
    return a.toString2() == b.toString2()
}

fun main() {
    // given
    val input = listOf(98, 98, 50, 100, 30, 90)
    val output = listOf(2, 2, 5, 1, 6, 4)

    assert(rankLogic(input), output).let { println(it) }
}