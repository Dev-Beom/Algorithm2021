package com.javaps.B1987;

import java.io.*;
import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int R, C, MAX;
    static char[][] board;
    static boolean[] check;

    static int[] xArr = {-1, 0, 1, 0};
    static int[] yArr = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        check = new boolean[26];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = str.charAt(c);
            }
        }
        MAX = 0;
        check[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(MAX);
    }

    static void dfs(int x, int y, int cnt) {
        if (MAX < cnt) {
            MAX = cnt;
        } else if (MAX == 26) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + xArr[i];
            int ny = y + yArr[i];
            if (isRange(nx, ny) && !check[board[nx][ny] - 'A']) {
                check[board[nx][ny] - 'A'] = true;
                dfs(nx, ny, cnt + 1);
                check[board[nx][ny] - 'A'] = false;
            }
        }
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }
}
