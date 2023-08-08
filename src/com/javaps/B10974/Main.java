package com.javaps.B10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) arr[i] = i + 1;
        permutation(arr, output, visit, 0, N, N);
    }

    private static void permutation(int[] arr, int[] output, boolean[] visit, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visit, depth + 1, n, r);
                visit[i] = false;
            }
        }
    }
}
