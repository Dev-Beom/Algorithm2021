package com.javaps.P124나라의숫자;

public class Main {
    class Solution {
        public String solution(int n) {
            return digitToNewDigit(n);
        }

        public String digitToNewDigit(int value) {
            String answer = "";
            String[] numbers = {"4", "1", "2"};
            while (value > 0) {
                int remainder = value % 3;
                value /= 3;

                if (remainder == 0) value--;
                answer = numbers[remainder] + answer;
            }
            return answer;
        }
    }
}
