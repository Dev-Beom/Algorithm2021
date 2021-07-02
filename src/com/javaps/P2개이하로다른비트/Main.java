package com.javaps.P2개이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = check(numbers[i]);
        }
        return answer;
    }

    public Long check(long number) {
        long result = number;
        if (number % 2 == 0) {//짝수
            result += 1;
        } else {//홀수
            int count = 0;
            while (number != 0) {
                count++;
                if (number % 2 == 0) break;
                number = number / 2;
            }
            if (number != 0)
                result += (Math.pow(2, count - 1) - Math.pow(2, count - 2));
            else result += (Math.pow(2, count) - Math.pow(2, count - 1));
        }
        return result;
    }
}