package com.javaps.B2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static enum Direction {
        Left, Right
    }

    static int R, C;
    static char[][] map;
    final static char BLOCK_MINERAL = 'x';
    final static char BLOCK_EMPTY = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int TC = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < TC; i++) {
            int row = Integer.parseInt(st.nextToken());
            castBar(i % 2 == 0 ? Direction.Left : Direction.Right, row);
            down(getAreas());
        }
        display();
    }

    private static void down(ArrayList<ArrayList<Node>> areas) {
        for (ArrayList<Node> nodes : areas) {
            if (!canDown(nodes)) continue;
            boolean isEnd = false;
            int newLine = 0;

            deleteBlocks(nodes);
            for (int cnt = 0; cnt < R; cnt++) {
                for (Node n : nodes) {
                    int ni = n.i + cnt;
                    if (isRange(ni, n.j) && map[ni][n.j] != BLOCK_MINERAL) continue;
                    isEnd = true;
                    newLine = cnt - 1;
                    break;
                }
                if (isEnd) break;
            }
            for (Node n : nodes) placeNewPosition(n, newLine);
        }
    }

    private static void placeNewPosition(Node n, int position) {
        map[n.i + position][n.j] = BLOCK_MINERAL;
    }

    private static void deleteBlocks(ArrayList<Node> nodes) {
        for (Node n : nodes) map[n.i][n.j] = BLOCK_EMPTY;
    }

    private static boolean canDown(ArrayList<Node> nodes) {
        for (Node n : nodes) {
            if (n.i == R - 1) return false;
        }
        return true;
    }

    private static ArrayList<ArrayList<Node>> getAreas() {
        int[] iArr = {-1, 0, 1, 0};
        int[] jArr = {0, -1, 0, 1};
        boolean[][] visited = new boolean[R][C];
        ArrayList<ArrayList<Node>> areas = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == BLOCK_MINERAL && !visited[i][j]) {
                    ArrayList<Node> nodes = new ArrayList<>();
                    Queue<Node> queue = new LinkedList<>();
                    Node currNode = new Node(i, j);
                    nodes.add(currNode);
                    queue.offer(currNode);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Node n = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ni = n.i + iArr[k];
                            int nj = n.j + jArr[k];
                            if (isRange(ni, nj) && !visited[ni][nj] && map[ni][nj] == BLOCK_MINERAL) {
                                Node newNode = new Node(ni, nj);
                                queue.offer(newNode);
                                nodes.add(newNode);
                                visited[ni][nj] = true;
                            }
                        }
                    }
                    areas.add(nodes);
                }
            }
        }
        return areas;
    }

    private static boolean isRange(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }

    private static void castBar(Direction direction, int row) {
        for (int i = 0; i < C; i++) {
            int currIndexByDirection = direction == Direction.Left ? i : C - 1 - i;
            char currBlock = map[R - row][currIndexByDirection];
            if (currBlock == BLOCK_MINERAL) {
                map[R - row][currIndexByDirection] = BLOCK_EMPTY;
                return;
            }
        }
    }

    private static void display() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
