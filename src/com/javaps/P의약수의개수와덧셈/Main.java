package com.javaps.P의약수의개수와덧셈;

import java.util.ArrayList;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer = getSize(i) % 2 == 0 ? answer + i : answer - i;
        }
        return answer;
    }

    static int getSize(int value) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= value; i++) {
            if (value % i == 0) list.add(i);
        }
        return list.size();
    }
}