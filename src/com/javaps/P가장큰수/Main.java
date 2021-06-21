package com.javaps.P가장큰수;

import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int length = numbers.length;

        // 숫자를 문자열로 변환
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴 ex. {0, 0, 0}
        if (result[0].equals("0")) return "0";

        // 정렬된 문자 합치기
        for (String item : result) {
            sb.append(item);
        }

        return sb.toString();
    }

}
