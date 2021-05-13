package com.javaps.B15683;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Node n) {
        if (this.value > n.value) return 1;
        return -1;
    }
}

public class Main {


    static int blindSpot = 0;
    static int N;
    static int M;
    static int[][] map;
    static LinkedList<Node> linkedList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // INIT VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로 크기
        M = Integer.parseInt(st.nextToken());   // 가로 크기

        map = new int[N][M];                // 사무실
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) {
                    blindSpot++;
                }
                map[i][j] = input;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] < 6) {
                    int maxValue= cctvAreaRecord(map[i][j], i, j);
                    if (maxValue > 0) {
                        linkedList.add(new Node(i, j, maxValue));
                    }
                }
            }
        }
        Collections.sort(linkedList);
        linkedList.forEach(
                x -> System.out.println(x.x + " : " + x.y+ " : " + x.value)
        );
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(blindSpot);
    }

    static int cctvAreaRecord(int cctvNumber, int n, int m) {
        // 좌, 상, 우, 하
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // CCTV 별 최대 CCTV가 비출 수 있는 수
        int max = 0;
        int maxIndex = 0;

        // 1. 단방향 CCTV에서 가장 최대 값을 찾음
        if (cctvNumber == 1) {
            int[] counts = new int[4];

            for (int i = 0; i < 4; i++) {
                counts[i] = 0;
            }
            for (int i = 0; i < 4; i++) {
                int nx = n + dx[i];
                int ny = m + dy[i];
                while (checkLocation(nx, ny)) {
                    counts[i]++;
                    // 더 들어가기
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
            }
            for (int i = 0; i < 4; i++) {
                if (max < counts[i]) {
                    max = counts[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
//            // 감시구역으로 체크하기
//            int nx = n + dx[maxIndex];
//            int ny = m + dy[maxIndex];
//            while (checkLocation(nx, ny)) {
//                if (map[nx][ny] == 0) {
//                    map[nx][ny] = 9;
//                    blindSpot--;
//                }
//                nx = nx + dx[maxIndex];
//                ny = ny + dy[maxIndex];
//            }

        } else if (cctvNumber == 2) {

        } else if (cctvNumber == 3) {

        } else if (cctvNumber == 4) {

        } else if (cctvNumber == 5) {

        } else {
        }
        return 0;
    }

    static boolean checkLocation(int x, int y) {
        if (y >= M || y < 0 || x >= N || x < 0) return false;
        if (map[x][y] == 6) return false;
        return true;
    }
}
