package com.javaps.P나누어떨어지는숫자배열;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        return getCommonMultiple(arr, divisor);
    }

    static int[] getCommonMultiple(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }
        if (list.size() == 0) {
            int[] result = {-1};
            return result;
        }
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}