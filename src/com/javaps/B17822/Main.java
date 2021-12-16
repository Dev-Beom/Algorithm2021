package com.javaps.B17822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void display() {
            System.out.println(i + ":" + j + " ");
        }
    }

    static enum Direction {
        RIGHT, LEFT
    }

    static int N, M, T;
    static int x, d, k;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (T-- > 0) {
            boolean hasNearNode = false;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            Direction direction = d == 0 ? Direction.RIGHT : Direction.LEFT;
            rotation(x, direction, k);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        ArrayList<Node> searchNearNode = BFS(new Node(i, j), map[i][j]);
                        if (searchNearNode.size() >= 2) {
                            hasNearNode = true;
                            deleteNode(searchNearNode);
                        }
                    }
                }
            }
            if (!hasNearNode) {
                int sum = 0, cnt = 0;
                double average;
                ArrayList<Node> willUpdateNodes = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] != 0) {
                            sum += map[i][j];
                            cnt++;
                            willUpdateNodes.add(new Node(i, j));
                        }
                    }
                }
                average = (double) sum / (double) cnt;
                for (Node n : willUpdateNodes) {
                    int currNodeValue = map[n.i][n.j];
                    if (currNodeValue < average) {
                        map[n.i][n.j] = currNodeValue + 1;
                    } else if (currNodeValue > average) {
                        map[n.i][n.j] = currNodeValue - 1;
                    }
                }
            }
        }
        System.out.println(getAllSumValue());
    }

    private static int getAllSumValue() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void deleteNode(ArrayList<Node> nodes) {
        for (Node n : nodes) {
            map[n.i][n.j] = 0;
        }
    }

    private static ArrayList<Node> BFS(Node node, int block) {
        int[] xArr = {0, 1, 0, -1};
        int[] yArr = {1, 0, -1, 0};

        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> response = new ArrayList<>();
        queue.offer(node);
        response.add(node);
        visited[node.i][node.j] = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ni = n.i + xArr[i];
                int nj = n.j + yArr[i];
                if (nj < 0) nj = M - 1;
                if (nj >= M) nj = 0;
                if (isRange(ni, nj) && !visited[ni][nj] && block == map[ni][nj]) {
                    Node newNode = new Node(ni, nj);
                    queue.offer(newNode);
                    response.add(newNode);
                    visited[ni][nj] = true;
                }
            }
        }
        return response;
    }

    private static boolean isRange(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    private static void rotation(int x, Direction direction, int count) {
        for (int i = 0; i < N; i++) {
            if ((i + 1) % x == 0) {
                Deque<Integer> deque = new LinkedList<>();
                for (int j = 0; j < M; j++) {
                    deque.addLast(map[i][j]);
                }
                for (int k = 0; k < count; k++) {
                    if (direction == Direction.RIGHT) {
                        deque.addFirst(deque.pollLast());
                    } else {
                        deque.addLast(deque.pollFirst());
                    }
                }
                int dequeIdx = 0;
                while (!deque.isEmpty()) {
                    map[i][dequeIdx] = deque.pollFirst();
                    dequeIdx++;
                }
            }
        }
    }
}