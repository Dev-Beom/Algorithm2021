package com.javaps.P숫자문자열과영단어;

class Solution {
    static String[] type = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] length = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public int solution(String s) {
        for (int i = 0; i <= 9; i++) s = s.replace(type[i], String.valueOf(length[i]));
        return Integer.parseInt(s);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("one4seveneight"));
        System.out.println(solution.solution("23four5six7"));
        System.out.println(solution.solution("2three45sixseven"));
        System.out.println(solution.solution("2three45sixsixseven"));
        System.out.println(solution.solution("123"));
    }
}
