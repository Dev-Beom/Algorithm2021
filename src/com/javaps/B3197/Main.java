package com.javaps.B3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static char[][] map;
    static ArrayList<Node> swans = new ArrayList<>();
    static Queue<Node> waters = new LinkedList<>();
    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] isVisited;

    static char WATER_AREA = '.';
    static char ICE_AREA = 'X';
    static char SWAN_AREA = 'L';
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char character = line.charAt(j);
                if (character == SWAN_AREA) {
                    swans.add(new Node(i, j));
                    waters.add(new Node(i, j));
                } else if (character == WATER_AREA) {
                    waters.add(new Node(i, j));
                }
                map[i][j] = character == SWAN_AREA ? WATER_AREA : character;
            }
        }

        Node from = swans.get(0);
        Node to = swans.get(1);
        isVisited[from.r][from.c] = true;
        queue.offer(from);

        while (!isMeet(to)) {
            melt();
            day++;
        }
        System.out.println(day);
    }

    private static boolean isMeet(Node to) {
        int[] xArr = {0, 1, -1, 0};
        int[] yArr = {1, 0, 0, -1};
        Queue<Node> nextQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.r == to.r && n.c == to.c) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int dx = n.r + xArr[i];
                int dy = n.c + yArr[i];
                if (isRange(dx, dy) && !isVisited[dx][dy]) {
                    isVisited[dx][dy] = true;
                    if (isIce(dx, dy)) {
                        nextQueue.offer(new Node(dx, dy));
                    } else if (!isIce(dx, dy)) {
                        queue.offer(new Node(dx, dy));
                    }
                }
            }
        }
        queue = nextQueue;
        return false;
    }

    private static void melt() {
        int[] xArr = {0, 1, -1, 0};
        int[] yArr = {1, 0, 0, -1};

        int watersSize = waters.size();
        for (int i = 0; i < watersSize; i++) {
            Node water = waters.poll();

            for (int j = 0; j < 4; j++) {
                assert water != null;
                int dx = water.r + xArr[j];
                int dy = water.c + yArr[j];
                if (isRange(dx, dy) && map[dx][dy] == ICE_AREA) {
                    map[dx][dy] = WATER_AREA;
                    waters.offer(new Node(dx, dy));
                }
            }
        }
    }

    private static boolean isRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    private static boolean isIce(int r, int c) {
        return map[r][c] == ICE_AREA;
    }

    private static void display() {
        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
