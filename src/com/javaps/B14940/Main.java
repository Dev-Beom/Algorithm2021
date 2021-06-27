package com.javaps.B14940;

/*
 * 문제 유형 : BFS / 그래프 이론
 * 문제 난이도 : 골드 5
 * 풀이 시간 : 18분 38초
 * 제출 실패 횟수 : 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;

    static Point start;
    static int[][] map;
    static boolean[][] visited;

    static int[] xArr = {1, 0, -1, 0};
    static int[] yArr = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int scan = Integer.parseInt(st.nextToken());
                if (scan == 1) map[i][j] = -1;
                if (scan == 2) {
                    map[i][j] = 0;
                    start = new Point(i, j);
                }
            }
        }
        bfs(start);
        print();
    }

    public static void bfs(Point start) {
        int cnt = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nx = point.x;
            int ny = point.y;
            for (int i = 0; i < 4; i++) {
                int dx = nx + xArr[i];
                int dy = ny + yArr[i];
                if (isRangeAndCondition(dx, dy)) {
                    queue.offer(new Point(dx, dy));
                    visited[dx][dy] = true;
                    map[dx][dy] = map[nx][ny] + 1;
                }
            }
        }
    }

    public static boolean isRangeAndCondition(int x, int y) {
        if (x >= n || x < 0 || y >= m || y < 0) return false;
        if (map[x][y] == 0) return false;
        if (visited[x][y]) return false;
        return true;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
