package com.javaps.B11403;

import java.util.*;
import java.io.*;

public class Main {

    static int M;

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        graph = new int[M][M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void search(int vertex) {
        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
    }
}
