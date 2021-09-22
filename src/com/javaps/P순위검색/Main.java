package com.javaps.P순위검색;


// 개발 언어 cpp, java, python : 1, 2, 3
// 직군 backend, frontend : 1, 2
// 경력 junior, senior : 1, 2
// 소울푸드 chicken, pizze : 1, 2
// 코딩테스트 : 1 <= n <= 100,000

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {

    static HashMap<String, ArrayList<Integer>> db = new HashMap<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        // info
        for (String data : info) {
            String[] tmp = data.split(" ");
            int score = Integer.parseInt(tmp[4]);
            Arrays.stream(getTokens(Arrays.copyOfRange(tmp, 0, 4))).forEach(e -> {
                if (!db.containsKey(e)) db.put(e, new ArrayList<Integer>());
                db.get(e).add(score);
            });
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : db.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // query
        for (String data : query) {
            String[] tmp = data.split(" and | ");
            String findQuery = tmp[0] + tmp[1] + tmp[2] + tmp[3];
            int score = Integer.parseInt(tmp[4]);
            ArrayList<Integer> rows = db.getOrDefault(findQuery, null);
            if (rows == null) {
                result.add(0);
                continue;
            }
            int idx = Collections.binarySearch(rows, score);
            if (idx >= 0) {
                for (int a = idx - 1; a >= 0; a--) {
                    if (rows.get(idx) - rows.get(a) > 0) break;
                    else idx = a;
                }
                result.add(rows.size() - idx);
            } else result.add(rows.size() + idx + 1);
        }
        int[] answer = new int[query.length];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private String[] getTokens(String[] row) {
        ArrayList<String> list = new ArrayList<>();
        String lang = row[0];
        String position = row[1];
        String career = row[2];
        String food = row[3];
        String none = "-";
        list.add(lang + position + career + food);
        list.add(lang + none + none + none);
        list.add(none + position + none + none);
        list.add(none + none + career + none);
        list.add(none + none + none + food);
        list.add(lang + position + none + none);
        list.add(lang + position + career + none);
        list.add(lang + position + none + food);
        list.add(lang + none + career + none);
        list.add(lang + none + career + food);
        list.add(lang + none + none + food);
        list.add(none + position + career + none);
        list.add(none + position + none + food);
        list.add(none + position + career + food);
        list.add(none + none + career + food);
        list.add(none + none + none + none);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}