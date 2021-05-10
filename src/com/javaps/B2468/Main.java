package com.javaps.B2468;

import java.util.*;
import java.io.*;


class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // SET VARIABLE
    static int N;
    static int[][] arr;
    static boolean[][] isVisited;
    static int maxSafetyArea;

    public static void main(String[] args) throws IOException {
        // SET VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minOfInputValue = 100;
        int maxOfInputValue = 0;

        // INIT VARIABLE
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                isVisited[i][j] = false;

                minOfInputValue = Math.min(minOfInputValue, arr[i][j]);
                maxOfInputValue = Math.max(maxOfInputValue, arr[i][j]);
            }
        }

        for (int precipitation = minOfInputValue; precipitation <= maxOfInputValue; precipitation++) {

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

//    public static void bfs()
}
