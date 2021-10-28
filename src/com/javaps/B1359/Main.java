package com.javaps.B1359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int CNT = 0;
    static int[] numbers;
    static boolean[] numberVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 갖고 있는 수
        int M = Integer.parseInt(st.nextToken());   // 고를 개수
        int K = Integer.parseInt(st.nextToken());   // 당첨 기준 개수
        numbers = new int[N];
        numberVisited = new boolean[N];
        for (int i = 0; i < N; i++) numbers[i] = i;
        combination(numbers, numberVisited, 0, numbers.length, M);
//        System.out.println((double) (N - K) / (double) CNT);
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            CNT++;
            print(arr, visited, n);

            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}