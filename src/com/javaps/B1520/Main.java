package com.javaps.B1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];
        DP = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static int dfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        if (x == M && y == N) return 1;
        if (DP[x][y] != -1) return DP[x][y];
        else {
            DP[x][y] = 0;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > M || ny > N) continue;
                if (map[x][y] > map[nx][ny]) DP[x][y] += dfs(nx, ny);
            }
        }
        return DP[x][y];
    }
}
