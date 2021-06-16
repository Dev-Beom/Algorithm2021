package com.javaps.P3진법뒤집기;

import java.util.*;

class Solution {
    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return getTernaryToDecimal(getTernaryReverse(n));
    }

    static int getTernaryToDecimal(int[] ternary) {
        int value = 0;
        int ternaryCount = 1;
        for (int i = 0; i < ternary.length; i++) {
            value += ternary[ternary.length - i - 1] * ternaryCount;
            ternaryCount *= 3;
        }
        return value;
    }

    static int[] getTernaryReverse(int value) {
        Queue<Integer> queue = new LinkedList<>();
        int queueSize = 0;
        for (;;) {
            queue.offer(value % 3);
            value = value / 3;
            queueSize++;
            if (value <= 2) {
                queue.offer(value);
                queueSize++;
                break;
            }
        }
        int[] ternary = new int[queueSize];
        for (int i = 0; i < queueSize; i++) {
            ternary[i] = queue.poll();
        }
        return ternary;
    }
}
