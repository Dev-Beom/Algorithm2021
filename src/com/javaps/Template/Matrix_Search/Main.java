package com.javaps.Template.Matrix_Search;

import java.util.*;
import java.io.*;

class Point {
    int row, col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
                visited[n][m] = false;
            }
        }
        bfs(0, 0);
    }

    public static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        visited[row][col] = true;

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nRow = point.row;
            int nCol = point.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];
                if (checkRangeAndPoint(x, y)) {
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    public static boolean checkRangeAndPoint(int row, int col) {
        // 맵 이탈 체크
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return false;
        }
        // 방문 체크
        if (visited[row][col]) {
            return false;
        }
        return true;
    }
}
