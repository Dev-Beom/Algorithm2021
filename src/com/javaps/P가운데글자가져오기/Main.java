package com.javaps.P가운데글자가져오기;
public class Main {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            if (s.length() % 2 == 0) {
                sb.append(s.charAt(s.length()/2 - 1)).append(s.charAt(s.length()/2));
                return sb.toString();
            }
            sb.append(s.charAt(s.length()/2));
            return sb.toString();
        }
    }
}
