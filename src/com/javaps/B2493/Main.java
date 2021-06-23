package com.javaps.B2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Data {
    int index, value;
    Data(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Data> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] tmp = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().value >= value) {
                    sb.append(stack.peek().index).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) sb.append("0 ");
            stack.push(new Data(i, value));
        }
        System.out.println(sb);
    }
}
