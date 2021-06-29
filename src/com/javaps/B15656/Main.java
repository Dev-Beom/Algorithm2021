package com.javaps.B15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        recursion(0, sb);
        System.out.println(sb);
    }

    public static void recursion(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                result[depth] = arr[i];
                recursion(depth + 1, sb);
            }
        }
    }
}
