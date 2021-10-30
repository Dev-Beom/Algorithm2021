package com.javaps.B1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] willVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 수
        int M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시의 수

        graph = new int[N][N];
        willVisit = new int[M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            willVisit[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < M - 1; i++) {
            int curr = willVisit[i];
            int next = willVisit[i + 1];
            if (!bfs(curr, next)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean bfs(int curr, int next) {
        if (graph[curr][next] == 1) return true;

        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visited[poll] = true;
            if (poll == next) return true;
            for (int i = 0; i < graph.length; i++) {
                if (graph[poll][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}
