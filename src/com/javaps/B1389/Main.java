package com.javaps.B1389;

import java.io.*;
import java.util.*;

class Node {
    int vertex;
    int dist;

    Node(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }
}

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관례의 수

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            bfs(i);
        }
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, answer[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (min == answer[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(vertex, 0));
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vtx = node.vertex;
            int dist = node.dist;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[vtx][i] == 1) {
                    queue.offer(new Node(i, dist + 1));
                    visited[i] = true;
                    answer[i] += dist + 1;
                }
            }
        }
    }
}
