package com.javaps.P서울에서김서방찾기;

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
