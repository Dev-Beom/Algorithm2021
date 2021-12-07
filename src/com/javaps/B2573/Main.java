package com.javaps.B2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;
    int adjacency = 0;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setAdjacency(int adjacency) {
        this.adjacency = adjacency;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int year = 0;

    static Queue<Node> icebergs = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value != 0) icebergs.offer(new Node(j, i));
                map[i][j] = value;
            }
        }
        while (true) {
            boolean isSeparation = melt();
            year++;
            if (isSeparation) break;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) cnt += map[i][j];
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(year);
    }

    public static boolean melt() {
        int[] xArr = {0, -1, 1, 0};
        int[] yArr = {1, 0, 0, -1};

        for (Node n : icebergs) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int dx = n.x + xArr[i];
                int dy = n.y + yArr[i];
                if (map[dy][dx] == 0) cnt++;
            }
            n.setAdjacency(cnt);
        }

        for (Node n : icebergs) {
            int newValue = map[n.y][n.x] - n.adjacency;
            n.setAdjacency(0);
            map[n.y][n.x] = Math.max(newValue, 0);
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    bfs(i, j);
                    visited[i][j] = true;
                    area++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        return area >= 2;
    }

    public static void bfs(int y, int x) {
        int[] xArr = {0, -1, 1, 0};
        int[] yArr = {1, 0, 0, -1};

        Queue<Node> searchQueue = new LinkedList<>();
        searchQueue.offer(new Node(x, y));

        while (!searchQueue.isEmpty()) {
            Node n = searchQueue.poll();
            visited[n.y][n.x] = true;
            for (int i = 0; i < 4; i++) {
                int dx = n.x + xArr[i];
                int dy = n.y + yArr[i];
                if (!visited[dy][dx] && map[dy][dx] > 0) {
                    visited[dy][dx]= true;
                    searchQueue.offer(new Node(dx, dy));
                }
            }
        }
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
