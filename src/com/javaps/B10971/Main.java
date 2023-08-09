package com.javaps.B10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start = 0; start < n; start++) {
            visited[start] = true;
            findShortestPath(start, start, 0, 0);
            visited[start] = false;
        }
        System.out.println(answer);
    }

    public static void findShortestPath(int start, int current, int sum, int depth) {
        if (depth == n - 1 && map[current][start] != 0) {
            sum += map[current][start];
            answer = Math.min(sum, answer);
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next] && map[current][next] > 0) {
                visited[next] = true;
                findShortestPath(start, next, sum + map[current][next], depth + 1);
                visited[next] = false;
            }
        }
    }
}
