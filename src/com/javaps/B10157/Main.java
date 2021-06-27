package com.javaps.B10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] xArr = {-1, 0, 1, 0};
    static int[] yArr = {0, 1, 0, -1};
    static int C, R, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        if (K > C * R) {
            System.out.println(0);
            return;
        }
        map = new int[R][C];

        int cnt = 1;
        int x = R - 1;
        int y = 0;
        int dir = 0;
        while (cnt != K) {
            map[x][y] = cnt;
            int nx = x + xArr[dir];
            int ny = y + yArr[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != 0) {
                dir++;
                if (dir == 4) dir = 0;
                nx = x + xArr[dir];
                ny = y + yArr[dir];
            }
            x = nx;
            y = ny;
            cnt++;
        }
        sb.append(y + 1).append(" ").append(R - x);
        System.out.println(sb);
    }
}
