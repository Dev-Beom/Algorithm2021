package com.javaps.B15650;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;

    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];
        isVisited = new boolean[10];

        func(0);
    }

    public static void func(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                arr[depth] = i;
                isVisited[i] = true;
                func(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
