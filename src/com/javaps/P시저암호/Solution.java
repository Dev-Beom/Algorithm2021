package com.javaps.P시저암호;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 32) sb.append(ch);
            else {
                if (isUpperCase(ch)) {
                    sb.append((char) ((ch - 'A' + n) % 26 + 'A'));
                } else if (isLowerCase(ch)) {
                    sb.append((char) ((ch - 'a' + n) % 26 + 'a'));
                }
            }
        }
        return sb.toString();
    }

    static private boolean isUpperCase(char ch) {
        return (ch >= 65 && ch <= 90);
    }

    static private boolean isLowerCase(char ch) {
        return (ch >= 97 && ch <= 122);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("AB", 1)); // "BC"
        System.out.println(solution.solution("z", 1));  // "a"
        System.out.println(solution.solution("a B z", 4));  // "e F d"
    }
}

