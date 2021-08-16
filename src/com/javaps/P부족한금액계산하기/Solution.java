package com.javaps.P부족한금액계산하기;

public class Solution {
    public long solution(int price, int money, int count) {
        long usePrice = 0;
        for (int i = 1; i <= count; i++) {
            usePrice += i * price;
        }
        return usePrice > money ? usePrice - money : 0;
    }
}