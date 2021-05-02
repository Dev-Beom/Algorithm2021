package com.javaps.B1926;
import java.io.*;
import java.util.*;


class Location {
    int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static int N = 0;   // 행
    static int M = 0;   // 열
    static int[][] arr;
    static boolean[][] isVisited;

    //  그림의 개수
    static int paintCount = 0;
    //  그림 중 가장 넓은 그림의 넓이
    static int paintSizeToBiggest = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                isVisited[i][j] = false;
            }
        }

        // 0.0 부터 N.M까지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // [i][j]를 방문하지 않았거나, 1이면
                if (!isVisited[i][j] && arr[i][j] == 1) {
                    paintCount++;

                    bfs(i, j);
                }
            }
        }
        System.out.println(paintCount);
        System.out.println(paintSizeToBiggest);
    }

    public static void bfs(int n, int m) {
        //  현재 그림의 크기
        int paintSize = 1;

        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(n, m));

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        isVisited[n][m] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];
                if (checkLocation(x, y)) {
                    queue.add(new Location(x, y));
                    paintSize++;
                    isVisited[x][y] = true;
                }
            }
        }
        maxPaintSize(paintSize);
    }

    public static boolean checkLocation(int row, int col) {
        if (row < 0 || row > N || col < 0 || col > M) return false;
        if (isVisited[row][col] || arr[row][col] == 0) return false;
        return true;
    }

    public static void maxPaintSize(int size) {
        if (size > paintSizeToBiggest) {
            paintSizeToBiggest = size;
        }
    }
}
