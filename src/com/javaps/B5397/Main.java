package com.javaps.B5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();
            System.out.println(getKeyLog(line));
        }
    }

    private static String getKeyLog(String line) {
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();

        for (Character c : line.toCharArray()) {
            if (c.equals('<')) {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (c.equals('>')) {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (c.equals('-')) {
                if (!left.isEmpty()) left.pop();
            } else {
                left.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        for (int i = 0; i < left.size(); i++) {
            sb.append(left.elementAt(i));
        }
        return sb.toString();

    }
}
