package com.javaps.P비밀지도;

import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            for (Integer e : sumArr(n, getBinary(n, arr1[i]), getBinary(n, arr2[i]))) {
                if (e == 0) sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }

    static int[] getBinary(int arrSize, int value) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = 0;
        for(;;) {
            stack.push(value % 2);
            size++;
            value = value / 2;
            if (value == 0 || value == 1) {
                stack.push(value);
                size++;
                break;
            }
        }
        int[] binaryArr = new int[arrSize];
        int idx = 0;
        while (!stack.isEmpty()) {
            binaryArr[(arrSize - size) + idx] = stack.pop();
            idx++;
        }
        return binaryArr;
    }

    static int[] sumArr(int arrSize, int[] arr1, int[] arr2) {
        int[] resultArr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) resultArr[i] = arr1[i] + arr2[i];
        return resultArr;
    }
}