package com.javaps.B4963;

import java.util.*;
import java.io.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int w;
    static int h;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            int area = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = false;
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        area += bfs(i, j);
                    }
                }
            }
            System.out.println(area);
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        int[] xArr = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] yArr = {1, 0, -1, 1, -1, 1, 0, -1};
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nx = point.x;
            int ny = point.y;
            for (int i = 0; i < 8; i++) {
                int dx = nx + xArr[i];
                int dy = ny + yArr[i];
                if (isRangeAndValid(dx, dy)) {
                    visited[dx][dy] = true;
                    queue.offer(new Point(dx, dy));
                }
            }
        }
        return 1;
    }

    public static boolean isRangeAndValid(int x, int y) {
        if (x < 0 || x >= h || y < 0 || y >= w) {
            return false;
        }
        if (map[x][y] == 0 || visited[x][y]) {
            return false;
        }
        return true;
    }
}
