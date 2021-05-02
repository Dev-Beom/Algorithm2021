package com.javaps.B2583;

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
    static int M = 0;   //  행
    static int N = 0;   //  열
    static int K = 0;   //  영역의 갯수

    static int[][] arr;
    static boolean[][] isVisited;


    static ArrayList<Integer> areaSizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        arr = new int[N][M];
        isVisited = new boolean[N][M];



        //  배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = 0;
                isVisited[i][j] = false;
            }
        }

        //  입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && arr[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(areaSizeList.size());
        //  오름차순
        areaSizeList.sort(Comparator.naturalOrder());
        areaSizeList.forEach(
                x -> System.out.print(x + " ")
        );
    }

    public static void bfs(int n, int m) {
        //  현재 빈 영역의 크기
        int areaSize = 0;
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(n, m));

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        isVisited[n][m] = true;
        areaSize++;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];
                if (checkLocation(x, y)) {
                    queue.add(new Location(x, y));
                    areaSize++;
                    isVisited[x][y] = true;
                }
            }
        }
        areaSizeList.add(areaSize);
    }

    public static boolean checkLocation(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) return false;
        if (isVisited[row][col] || arr[row][col] == 1) return false;
        return true;
    }

    // Print Test
    public static void display() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(arr.length);
    }
}
