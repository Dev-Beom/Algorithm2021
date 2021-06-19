package com.javaps.P게임맵최단거리;

import java.util.*;

class Point {
    int x, y, cost;
    Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class Solution {
    static int N, M;
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;

        N = maps.length;
        M = maps[0].length;

        visited = new boolean[N][M];

        return BFS(0, 0, maps);
    }

    static int BFS(int a, int b, int[][] map) {

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b, 1));
        visited[a][b] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int cost = point.cost;
            if (x == N - 1 && y == M - 1) {
                return cost;
            }
            for (int i = 0; i < 4; i++) {
                int dx = xArr[i] + x;
                int dy = yArr[i] + y;
                if (isRange(dx, dy) && !visited[dx][dy] && map[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    queue.offer(new Point(dx, dy, cost + 1));
                }
            }
        }
        return -1;
    }

    static boolean isRange(int x, int y) {
        if (x >= N || x < 0 || y >= M || y < 0) return false;
        return true;
    }
}