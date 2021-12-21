package com.javaps.B1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int i, j, cnt;

        Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        public boolean isFinished(int i, int j) {
            return this.i == i && this.j == j;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(BFS(new Node(0, 0, 0)));
    }

    private static int BFS(Node start) {
        int[] iArr = {0, 1, 0, -1};
        int[] jArr = {1, 0, -1, 0};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        priorityQueue.offer(start);
        visited[start.i][start.j] = true;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            if (node.isFinished(N - 1, M - 1)) {
                return node.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int di = node.i + iArr[i];
                int dj = node.j + jArr[i];
                if (!isRange(di, dj)) continue;
                if (!visited[di][dj] && map[di][dj] == 0) {
                    visited[di][dj] = true;
                    priorityQueue.offer(new Node(di, dj, node.cnt));
                }
                if (!visited[di][dj] && map[di][dj] == 1) {
                    visited[di][dj] = true;
                    priorityQueue.offer(new Node(di, dj, node.cnt + 1));
                }
            }
        }
        return 0;
    }

    private static boolean isRange(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
