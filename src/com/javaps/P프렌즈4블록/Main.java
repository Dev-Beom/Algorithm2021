package com.javaps.P프렌즈4블록;

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static int m;
    static int n;
    static char[][] map;
    static Queue<Point> deleteQueue = new LinkedList<>();
    static int[] xArr = {0, 0, 1, 1};
    static int[] yArr = {0, 1, 1, 0};
    static int count = 0;

    public int solution(int m, int n, String[] board) {
        // initialize variable
        int answer = 0;
        this.m = m;
        this.n = n;
        map = new char[m][n];

        boolean isFinish = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }


        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isRange(i, j) && isSame(i, j) && map[i][j] != '*') {
                        inputToQueue(i, j);
                        isFinish = false;
                    }
                }
            }
            deleteAndDown();
            if (isFinish == true) {
                break;
            }
            if (isFinish == false) {
                isFinish = true;
            }
        }

        // Display
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        return count;
    }

    static boolean isRange(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = xArr[i] + x;
            int dy = yArr[i] + y;
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) return false;
        }
        return true;
    }

    static boolean isSame(int x, int y) {
        boolean state = false;
        for (int i = 0; i < 4; i++) {
            int dx = xArr[i] + x;
            int dy = yArr[i] + y;
            if (map[x][y] == map[dx][dy]) state = true;
            else return false;
        }
        return state;
    }

    static void inputToQueue(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = xArr[i] + x;
            int dy = yArr[i] + y;
            deleteQueue.offer(new Point(dx, dy));
        }
    }

    static void deleteAndDown() {
        while (!deleteQueue.isEmpty()) {
            Point point = deleteQueue.poll();
            if (map[point.x][point.y] != '*') count++;
            map[point.x][point.y] = '*';
        }
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != '*' && map[i + 1][j] == '*') {
                        map[i + 1][j] = map[i][j];
                        map[i][j] = '*';
                    }
                }
            }
        }
    }
}