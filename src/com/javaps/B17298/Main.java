package com.javaps.B17298;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // INIT VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        // 수열 A의 크기 N
        int N = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // LOGIC
        for (int idx = 0; idx < N; idx++) {
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[idx]) {
                sequence[stack.pop()] = sequence[idx];
            }

            stack.push(idx);
        }
        while (!stack.isEmpty()) {
            sequence[stack.pop()] = -1;
        }
        for (int i = 0; i < sequence.length; i++) {
            sb.append(sequence[i]).append(' ');
        }
        System.out.println(sb);
    }
}
