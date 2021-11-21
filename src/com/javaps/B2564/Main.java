package com.javaps.B2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, cnt;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int row, column;
    static int storeCnt;
    static int myRow, myColumn;
    static int[][] map;
    static boolean[][] visited;
    static int sum = 0;
    static List<Node> nodeList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        map = new int[column + 1][row + 1];

        storeCnt = Integer.parseInt(br.readLine());
        fillCenter();

        for (int i = 0; i <= storeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            int x = 0;
            int y = 0;
            switch (location) {
                case 1:
                    x = distance;
                    break;
                case 2:
                    x = distance;
                    y = column;
                    break;
                case 3:
                    y = distance;
                    break;
                case 4:
                    x = row;
                    y = distance;
                    break;
            }
            if (i == storeCnt) {
                myRow = x;
                myColumn = y;
            } else {
                nodeList.add(new Node(x, y));
            }
        }
        for (Node node : nodeList) {
            sum += bfs(node);
        }
        System.out.println(sum);
    }

    static private int bfs(Node node) {
        visited = new boolean[column + 1][row + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(myRow, myColumn, 0));
        int[] xArr = {0, 1, 0, -1};
        int[] yArr = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            visited[n.y][n.x] = true;
            if (n.x == node.x && n.y == node.y) {
                return n.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int dx = n.x + xArr[i];
                int dy = n.y + yArr[i];
                if (isRange(dx, dy) && !visited[dy][dx]) {
                    queue.offer(new Node(dx, dy, n.cnt + 1));
                }
            }
        }
        return 0;
    }

    static private boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < map[0].length && y < map.length && map[y][x] != 1;
    }

    static private void fillCenter() {
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                map[i][j] = 1;
            }
        }
    }
}
