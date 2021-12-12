package com.javaps.P없는숫자더하기;

class Solution {
    public int solution(int[] numbers) {
        int max = 45;
        for (Integer number: numbers) {
            max -= number;
        }
        return max;
    }
}