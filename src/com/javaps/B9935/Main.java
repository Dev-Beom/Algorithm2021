package com.javaps.B9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String original = br.readLine();
        String remove = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            stack.push(ch);
            if (stack.size() >= remove.length()) {
                boolean isBoom = true;
                for (int j = 0; j < remove.length(); j++) {
                    if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    for (int j = 0; j < remove.length(); j++) stack.pop();
                }
            }
        }
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}

