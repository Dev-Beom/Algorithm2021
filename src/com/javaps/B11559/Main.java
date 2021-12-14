package com.javaps.B11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node {
        int X, Y;

        Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }

    final static char EMPTY_AREA = '.';
    final static int X = 6, Y = 12;
    static int time = 0;
    static char[][] map = new char[Y][X];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < Y; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = readLine.charAt(j);
            }
        }
        while (true) {
            boolean isBoom = false;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    char color = map[i][j];
                    if (color != EMPTY_AREA) {
                        Queue<Node> responseQueue = BFS(color, j, i);
                        if (responseQueue.size() >= 4) {
                            boom(responseQueue);
                            isBoom = true;
                        }
                    }
                }
            }
            if (!isBoom) break;
            down();
            time++;
        }
        System.out.println(time);
    }

    private static Queue<Node> BFS(char color, int x, int y) {
        boolean[][] visited = new boolean[Y][X];
        int[] xArr = {0, 1, 0, -1};
        int[] yArr = {1, 0, -1, 0};
        Queue<Node> searchQueue = new LinkedList<>();
        Queue<Node> responseQueue = new LinkedList<>();
        searchQueue.offer(new Node(x, y));

        while (!searchQueue.isEmpty()) {
            Node n = searchQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.X + xArr[i];
                int ny = n.Y + yArr[i];
                if (isRange(nx, ny) && !visited[ny][nx] && map[ny][nx] == color) {
                    visited[ny][nx] = true;
                    searchQueue.offer(new Node(nx, ny));
                    responseQueue.offer(new Node(nx, ny));
                }
            }
        }
        return responseQueue;
    }

    private static void boom(Queue<Node> boomList) {
        while (!boomList.isEmpty()) {
            Node n = boomList.poll();
            map[n.Y][n.X] = EMPTY_AREA;
        }
    }

    private static void down() {
        for (int i = 0; i < X; i++) {
            ArrayList<Character> downList = new ArrayList<>();
            for (int j = 0; j < Y; j++) {
                char currBlock = map[j][i];
                if (currBlock != EMPTY_AREA) {
                    downList.add(currBlock);
                }
            }
            if (downList.isEmpty()) continue;
            clearLine(i);
            placeLine(i, downList);
        }
    }

    private static void clearLine(int x) {
        for (int i = 0; i < Y; i++) {
            map[i][x] = EMPTY_AREA;
        }
    }

    private static void placeLine(int x, ArrayList<Character> blocks) {
        for (int i = 0; i < blocks.size(); i++) {
            map[Y - 1 - i][x] = blocks.get(blocks.size() - 1 - i);
        }
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}
