package com.javaps.P하샤드수;

class Solution {
    public boolean solution(int x) {
        return isHashad(x);
    }

    static boolean isHashad(int value) {
        String str = Integer.toString(value);
        if (value % stringToSumValue(str) == 0) {
            return true;
        }
        return false;
    }

    static int stringToSumValue(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i) - '0';
        }
        return sum;
    }

}