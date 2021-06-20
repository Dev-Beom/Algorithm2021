package com.javaps.P올바른괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
            } else if (ch == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}