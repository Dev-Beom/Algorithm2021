package com.javaps.P문자열압축;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder str = new StringBuilder();
            String tmp = "";
            int cnt = 1;
            for (int j = 0; j < s.length() / i; j++) {
                String currStr = s.substring(i * j, i * j + i);
                if (tmp.equals(currStr)) {
                    cnt++;
                    continue;
                }
                if (cnt > 1) {
                    str.append(cnt + tmp);
                    cnt = 1;
                } else str.append(tmp);
                tmp = currStr;
            }
            if (cnt > 1) {
                str.append(cnt).append(tmp);
                cnt = 1;
            } else str.append(tmp);
            if (s.length() % i != 0) str.append(s.substring(s.length() - s.length() % i));
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
}