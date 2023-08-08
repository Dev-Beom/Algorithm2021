package com.javaps.B10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(arr, new int[N], visit, 0, N, N);
        System.out.println(MAX);
    }

    private static void permutation(int[] arr, int[] output, boolean[] visit, int depth, int n, int r) {
        if (depth == r) {
            MAX = Math.max(getMax(output), MAX);
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

    private static int getMax(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            result = result + Math.abs(arr[i] - arr[i + 1]);
        }
        return result;
    }
}
