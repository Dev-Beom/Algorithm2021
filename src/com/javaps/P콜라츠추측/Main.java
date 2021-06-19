package com.javaps.P콜라츠추측;

class Solution {
    public int solution(int num) {
        long value = num;
        int answer = 0;
        while (value != 1) {
            answer++;
            value = value % 2 == 0 ? value / 2 : value * 3 + 1;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }
}