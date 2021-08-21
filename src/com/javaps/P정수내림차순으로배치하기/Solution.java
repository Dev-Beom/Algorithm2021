package com.javaps.P정수내림차순으로배치하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        String numberStr = Long.toString(n);
        for (int i = 0; i < numberStr.length(); i++) {
            arr.add(numberStr.charAt(i) - '0');
        }
        Collections.sort(arr, Collections.reverseOrder());
        arr.forEach(e -> {
            sb.append(e);
        });
        return Long.parseLong(sb.toString());
    }
}