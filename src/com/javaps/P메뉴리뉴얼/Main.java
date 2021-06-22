package com.javaps.P메뉴리뉴얼;

import java.util.*;

class Solution {
    // 맵을 메뉴의 개수만큼 나열하기 위해
    List<Map<String, Integer>> foodMaps = new ArrayList<>();
    int[] max = new int[11];

    void comb(char[] str, int pos, StringBuilder candi) {
        if (pos >= str.length) {
            int len = candi.length();
            if (len >= 2) {
                // 리스트 중 문자열크기의 인덱스로 접근 후, candi 문자열이 존재하면 + 1, 아니면 0;
                int cnt = foodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                foodMaps.get(len).put(candi.toString(), cnt);
                max[len] = Math.max(max[len], cnt);
            }
            return;
        }

        comb(str, pos + 1, candi.append(str[pos]));
        candi.setLength(candi.length() - 1);
        comb(str, pos + 1, candi);
    }


    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i <= 10; i++)
            foodMaps.add(new HashMap<String, Integer>());

        // 조합식
        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();

        for (int len : course) {
            for (Map.Entry<String, Integer> entry : foodMaps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == max[len]) {
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}