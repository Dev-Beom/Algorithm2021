package com.javaps.B14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
    int x, y, d;
    int[][] map;
    int count = 0;

    // 북, 동, 남, 서
    int[] xArr = {-1, 0, 1, 0};
    int[] yArr = {0, 1, 0, -1};

    Robot(int x, int y, int d, int[][] map) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.map = map;
    }

    private void cleanUp() {
        if (map[x][y] == 0) {
            map[x][y] = 2;
            count++;
        }
    }

    private void turn() {
        d = (d + 3) % 4;
    }

    private void move() {
        x = x + xArr[d];
        y = y + yArr[d];
    }

    private void backMove() {
        x = x - xArr[d];
        y = y - yArr[d];
    }

    private boolean canCleanUp() {
        int dx = x + xArr[d];
        int dy = y + yArr[d];
        return map[dx][dy] == 0;
    }

    public void run() {
        int i;
        while (true) {
            cleanUp();
            for (i = 0; i < 4; i++) {
                turn();
                if (canCleanUp()) {
                    move();
                    break;
                }
            }
            if (i == 4) {
                backMove();
                if (map[x][y] == 1) {
                    return;
                }
            }
        }
    }
}

public class Main {
    static int N, M;    // 세로, 가로
    static int R, C, D; // Y좌표, X좌표, 방향

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Robot robot = new Robot(R, C, D, map);
        robot.run();
        System.out.println(robot.count);
    }
}
