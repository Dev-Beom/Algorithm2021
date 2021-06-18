package com.javaps.P카카오프렌즈컬러링북;

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int M;
    static int N;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        M = picture.length;     // 세로 요소의 갯수
        N = picture[0].length;  // 가로 요소의 개수
        visited = new boolean[M][N];    // 방문 처리

        // 완전 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int size = BFS(i, j, picture, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea < size ? size : maxSizeOfOneArea;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int BFS(int i, int j, int[][] picture, int value) {
        int size = 1;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for (int t = 0; t < 4; t++) {
                int dx = x + xArr[t];
                int dy = y + yArr[t];
                if (isRange(dx, dy) &&
                        !visited[dx][dy] &&
                        picture[dx][dy] == value) {
                    size ++;
                    queue.offer(new Point(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
        return size;
    }

    static boolean isRange(int x, int y) {
        if (x >= M || x < 0 || y >= N || y < 0) return false;
        return true;
    }
}