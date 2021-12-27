package com.javaps.B16938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int questionCase = 0;
    static int N, L, R, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i <= N; i++) {
            boolean[] visited = new boolean[N];
            backtracking(arr, visited, 0, N, i);
        }
        System.out.println(questionCase);
    }

    private static void backtracking(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0 && isValid(arr, visited, n)) {
            questionCase++;
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            backtracking(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static boolean isValid(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                int currValue = arr[i];
                sum += currValue;
                max = Math.max(currValue, max);
                min = Math.min(currValue, min);
            }
        }
        return sum >= L && R >= sum && (max - min) >= X;
    }
}
