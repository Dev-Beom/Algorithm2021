package com.kotlinps.B17479

import java.util.StringTokenizer

class Order {
    var basicMenuPrice = 0L
    var specialMenuPrice = 0L
    var countOfSpecialMenu = 0
    var countOfServiceMenu = 0

    fun canSpecialMenuOrder(): Boolean {
        return basicMenuPrice >= 20000;
    }

    fun canServiceMenuOrder(): Boolean {
        return basicMenuPrice + specialMenuPrice >= 50000
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val stringTokenizer = StringTokenizer(readLine())
    val countOfBasicMenu = stringTokenizer.nextToken().toLong()
    val countOfSpecialMenu = stringTokenizer.nextToken().toLong()
    val countOfServiceMenu = stringTokenizer.nextToken().toLong()

    val basicMenu = mutableMapOf<String, Long>()
    val specialMenu = mutableMapOf<String, Long>()
    val serviceMenu = mutableSetOf<String>()
    for (i in 1..countOfBasicMenu) {
        val line = StringTokenizer(readLine())
        val name = line.nextToken()
        val price = line.nextToken().toLong()
        basicMenu[name] = price
    }
    for (i in 1..countOfSpecialMenu) {
        val line = StringTokenizer(readLine())
        val name = line.nextToken()
        val price = line.nextToken().toLong()
        specialMenu[name] = price
    }
    for (i in 1..countOfServiceMenu) {
        serviceMenu.add(readLine())
    }
    val orderState = Order()
    val countOfOrder = readLine().toLong()
    for (i in 1..countOfOrder) {
        val menu = readLine()
        if (basicMenu.containsKey(menu) || specialMenu.containsKey(menu) || serviceMenu.contains(menu)) {
            if (basicMenu.containsKey(menu)) {
                orderState.basicMenuPrice += basicMenu[menu]!!
            } else if (specialMenu.containsKey(menu)) {
                orderState.specialMenuPrice += specialMenu[menu]!!
                orderState.countOfSpecialMenu++
            } else if (serviceMenu.contains(menu)) {
                orderState.countOfServiceMenu++
            }
        } else {
            return print("No")
        }
    }

    if (orderState.countOfServiceMenu > 1) return print("No")
    if (orderState.countOfSpecialMenu >= 1 && !orderState.canSpecialMenuOrder()) return print("No")
    if (orderState.countOfServiceMenu > 0 && !orderState.canServiceMenuOrder()) return print("No")
    print("Okay")
}