package com.javaps.B6603;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) return;
            int[] arr = new int[N];
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            combination(arr, visited, 0, 6);
            System.out.println();
        }
    }

    static void combination(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            print(arr, visited);
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++)
            if (visited[i])
                System.out.print(arr[i] + " ");
        System.out.println();
    }
}
