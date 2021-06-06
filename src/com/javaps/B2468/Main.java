package com.javaps.B2468;

import java.util.*;
import java.io.*;


class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // SET VARIABLE
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int maxSafetyArea;

    public static void main(String[] args) throws IOException {
        // SET VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minOfInputValue = 100;
        int maxOfInputValue = 0;

        // INIT VARIABLE
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                isVisited[i][j] = false;

                minOfInputValue = Math.min(minOfInputValue, map[i][j]);
                maxOfInputValue = Math.max(maxOfInputValue, map[i][j]);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        System.out.println(minOfInputValue);
        System.out.println(maxOfInputValue);
        for (int precipitation = minOfInputValue; precipitation < maxOfInputValue; precipitation++) {
            Queue<Node> queue = new LinkedList<>();
            int area = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > precipitation || !isVisited[i][j]) {
                        // 안전 영역 구하기
                        area++;
                        queue.add(new Node(i, j));
                        isVisited[i][j] = true;
                        while (!queue.isEmpty()) {
                            Node node = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = node.x + dx[k];
                                int y = node.y + dy[k];
                                if (checkLocation(x, y, precipitation)) {
                                    area++;
                                    queue.add(new Node(x, y));
                                    isVisited[x][y] = true;
                                }
                            }
                        }
                    }
                }
            }
                System.out.println(area);
            if (maxSafetyArea < area) {
                maxSafetyArea = area;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    isVisited[i][j] = false;
                }
            }

        }
        System.out.println(maxSafetyArea);
    }

    public static boolean checkLocation(int x, int y, int value) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        if (isVisited[x][y] || map[x][y] < value) {
            return false;
        }
        return true;
    }
}
