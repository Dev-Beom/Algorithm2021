package com.javaps.P예산;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (Integer e : d) {
            if (budget - e < 0) {
                break;
            }
            budget -= e;
            answer++;
        }
        return answer;
    }
}
