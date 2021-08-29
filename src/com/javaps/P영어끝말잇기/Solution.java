package com.javaps.P영어끝말잇기;

import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> useWords = new HashMap<>();
    static String currentWord;

    public int[] solution(int n, String[] words) {
        int num = 0;
        int cnt = 0;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                currentWord = words[i];
                useWords.put(words[i], 0);
                continue;
            }
            if (currentWord.charAt(currentWord.length() - 1)
                    == words[i].charAt(0)) {
                if (useWords.containsKey(words[i])) {
                    num = i % n + 1;
                    cnt = i / n + 1;
                    break;
                }
                currentWord = words[i];
                useWords.put(words[i], 0);
            } else {
                num = i % n + 1;
                cnt = i / n + 1;
                break;
            }
        }
        int[] answer = {num, cnt};
        return answer;
    }
}