package com.javaps.PJadenCase문자열만들기;

public class Main {
    static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            boolean startCharIsAlphabet = true;
            boolean isFirst = true;
            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);
                if (isFirst) {
                    // 띄어쓰기일 경우
                    if (ch == 32) {
                        isFirst = true;
                        sb.append(" ");
                        continue;
                    }
                    if (isAlphabet(ch)) {
                        startCharIsAlphabet = true;
                        if (lowerOrUpper(ch)) {
                            sb.append(toUpper(ch));
                        } else {
                            sb.append(ch);
                        }
                    } else {
                        startCharIsAlphabet = false;
                        sb.append(ch);
                    }
                    isFirst = false;
                } else {
                    // 띄어쓰기일 경우
                    if (ch == 32) {
                        isFirst = true;
                        sb.append(" ");
                    } else {
                        if (!lowerOrUpper(ch)) {
                            sb.append(toLower(ch));
                        } else {
                            sb.append(ch);
                        }
                    }
                }


            }
            return sb.toString();
        }

        public static boolean isAlphabet(char ch) {
            if (ch >= 65 && ch <= 90) return true;
            if (ch >= 97 && ch <= 122) return true;
            return false;
        }

        // true: Lower, false: Upper
        // 소문자 : true
        // 대문자 : false
        public static boolean lowerOrUpper(char ch) {
            if (ch >= 97 && ch <= 122) return true;
            if (ch >= 65 && ch <= 90) return false;
            return false;
        }

        public static char toUpper(char ch) {
            return (char)(ch - 32);
        }

        public static char toLower(char ch) {
            return (char)(ch + 32);
        }
    }
}
