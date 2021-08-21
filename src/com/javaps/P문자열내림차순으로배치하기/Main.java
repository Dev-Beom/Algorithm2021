package com.javaps.P문자열내림차순으로배치하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }
        Collections.sort(characters, Collections.reverseOrder());
        characters.forEach(sb::append);
        return sb.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));

    }
}
