package com.javaps.B11724;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int N, M, start, end, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        sum = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                sum += bfs(i);
            }
        }
        System.out.println(sum);
    }

    static int bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i <= N; i++) {
                // 다음 정점과 연결되어 있고, 아직 방문하지 않았다면
                if (graph[x][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return 1;
    }
}
