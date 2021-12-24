package com.javaps.B21938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int i, j;
        double value;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        Node(int i, int j, double value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    final static int MAX_COLOR = 255;
    final static int MIN_COLOR = 0;
    static int N, M, T;
    static int objects = 0;
    static double[][] map;
    static boolean[][] visited;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> (int) (o1.value - o2.value));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new double[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                double value = (double) (R + G + B) / 3;
                map[i][j] = value;
                priorityQueue.offer(new Node(i, j, value));
            }
        }
        T = Integer.parseInt(br.readLine());
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            if (node.value >= T) map[node.i][node.j] = MAX_COLOR;
            else if (node.value < T) map[node.i][node.j] = MIN_COLOR;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == MAX_COLOR && !visited[i][j]) {
                    BFS(i, j);
                    objects++;
                }
            }
        }
        System.out.println(objects);
    }

    private static void BFS(int i, int j) {
        int[] iArr = {0, 1, 0, -1};
        int[] jArr = {1, 0, -1, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int idx = 0; idx < 4; idx++) {
                int ni = node.i + iArr[idx];
                int nj = node.j + jArr[idx];
                if (isRange(ni, nj) && !visited[ni][nj] && map[ni][nj] == MAX_COLOR) {
                    visited[ni][nj] = true;
                    queue.offer(new Node(ni, nj));
                }
            }
        }
    }

    private static boolean isRange(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
