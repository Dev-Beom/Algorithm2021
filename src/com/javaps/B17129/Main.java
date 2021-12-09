package com.javaps.B17129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int i, j, type;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

enum displayType {
    MAP, DP, VISITED
}

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static Node familyLocation;
    static ArrayList<Node> spotList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int block = Integer.parseInt(String.valueOf(line.charAt(j)));
                map[i][j] = block;
                if (isFamilyLocation(block)) {
                    familyLocation = new Node(i, j);
                } else if (isRestaurantLocation(block)) {
                    spotList.add(new Node(i, j));
                }
            }
        }
        BFS();
        int answer = Integer.MAX_VALUE;
        for (Node spot : spotList) {
            int spotValue = dp[spot.i][spot.j];
            if (spotValue < answer && spotValue != 0) answer = spotValue;
        }
        System.out.println(answer == Integer.MAX_VALUE ? "NIE" : "TAK\n" + answer);
    }

    public static void BFS() {
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(familyLocation);

        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.poll();
            for (int i = 0; i < 4; i++) {
                int di = n.i + xArr[i];
                int dj = n.j + yArr[i];
                if (isRange(di, dj) && !isWall(di, dj) && dp[di][dj] == 0) {
                    dp[di][dj] = dp[n.i][n.j] + 1;
                    nodeQueue.offer(new Node(di, dj));
                }
            }
        }
    }

    public static boolean isWall(int i, int j) {
        return map[i][j] == 1;
    }

    public static boolean isRange(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    public static boolean isFamilyLocation(int block) {
        return block == 2;
    }

    public static boolean isRestaurantLocation(int block) {
        return 3 <= block && block <= 5;
    }

    public static void display(displayType type) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (type == displayType.DP) {
                    System.out.print(dp[i][j]);
                } else if (type == displayType.MAP) {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
