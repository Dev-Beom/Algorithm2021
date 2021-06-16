package com.javaps.P같은숫자는싫어;

import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = -1;
                } else {
                    break;
                }
            }
        }
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                size++;
            }
        }
        int[] answer = new int[size];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}