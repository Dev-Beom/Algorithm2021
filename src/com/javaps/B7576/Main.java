package com.javaps.B7576;

import java.io.*;
import java.util.*;

class Point {
    int row, col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static int M; // 상자의 가로 칸의 수
    static int N; // 상자의 세로 칸의 수

    static int[][] arr;
    static boolean[][] isVisited;

    static int day;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // BFS 시작 노드를 큐에 추가
                if (arr[i][j] == 1) queue.add(new Point(i, j));
            }
        }

        day = bfs();
        System.out.println(day);
    }

    public static int bfs() {
        // 최댓값을 담을 변수
        int result = 0;

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int row = point.row;
            int col = point.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];

                // 익을 수 있는 경우 TRUE
                if (checkLocation(x, y)) {

                    // 익을 수 있는 토마토를 큐에 추가
                    queue.add(new Point(x, y));

                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    arr[x][y] = arr[row][col] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 예외 처리 - 하나라도 익지 않은 토마토가 있는 경우
                if (arr[i][j] == 0) return -1;

                // 토마토가 익는데 걸리는 시간 - 배열의 모든 요소중 최대값
                result = Math.max(result, arr[i][j]);
            }
        }

        // 최댓값이 1이면 모두 익어있던 경우
        if(result == 1) return 0;

        // 최대값 - 1은 걸린 일수
        return (result - 1);
    }

    public static boolean checkLocation(int row, int col) {
        // 범위 검사 후 밖이면 FALSE
        if (row < 0 || row > N - 1 || col < 0 || col > M - 1) return false;

        // 아직 익지 않은 토마토라면 TRUE
        if (arr[row][col] == 0) return true;

        // 이미 익은경우(1) 혹은 빈자리(-1) 인 경우 FALSE
        return false;
    }
}