package com.javaps.P짝지어제거하기;


import java.util.*;


class Solution {
    static Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else {
                if (stack.peek() == s.charAt(i)) stack.pop();
                else if (stack.peek() != s.charAt(i)) stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) return 1;
        return 0;
    }
}