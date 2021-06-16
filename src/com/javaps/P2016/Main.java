package com.javaps.P2016;

class Solution {
    static String[] dayOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};

    public String solution(int a, int b) {
        int day = 0;
        for (int i = 1; i < a; i++) {
            day += dayOfMonth[i - 1];
        }
        day += b - 1;
        return dayOfTheWeek[(day + 5) % 7];
    }
}