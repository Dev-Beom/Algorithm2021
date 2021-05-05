// 적록 색약

package com.javaps.B10026;

import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static char[][] RGB;
    static char[][] RB;
    static boolean[][] isVisited;

    static int RGBCount;
    static int RBCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // INIT VARIABLE
        N = Integer.parseInt(st.nextToken());
        RGB = new char[N][N];
        RB = new char[N][N];
        isVisited = new boolean[N][N];
        RGBCount = 0;
        RBCount = 0;


        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                // 정상
                RGB[i][j] = tmp[j];

                // 적록색약
                if (tmp[j] == 'G') RB[i][j] = 'R';
                else RB[i][j] = tmp[j];
            }
        }

        // 정상 BFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    RGBCount += bfs(i, j, RGB[i][j], RGB);
                }
            }
        }

        // 적록색약 BFS
        clearIsVisited();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    RBCount += bfs(i, j, RB[i][j], RB);
                }
            }
        }
        System.out.print(RGBCount + " " + RBCount);
    }

    public static int bfs(int n, int m, char option, char[][] arrs) {
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, m));
        isVisited[n][m] = true;

        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        count++;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + xArr[i];
                int ny = node.y + yArr[i];
                if (checkOption(nx, ny, option, arrs)) {
                    queue.add(new Node(nx, ny));
                    isVisited[nx][ny] = true;
                }
            }
        }
        return count;
    }

    public static void clearIsVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    public static boolean checkOption(int x, int y, char option, char[][] arrs) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        if (isVisited[x][y] || arrs[x][y] != option) {
            return false;
        }
        return true;
    }

    public static void display(char[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}