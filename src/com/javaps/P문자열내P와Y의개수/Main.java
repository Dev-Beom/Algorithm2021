package com.javaps.P문자열내P와Y의개수;

class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        for (String e : seoul) {
            if (e.equals("Kim")) return "김서방은 " + idx + "에 있다";
            idx++;
        }
        return "";
    }
}