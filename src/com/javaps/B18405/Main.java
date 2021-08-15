package com.javaps.B18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Main {
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((Node o1, Node o2) -> o1.value >= o2.value ? 1 : -1);
    static int N;   //  시험관의 크기
    static int K;   //  나올 수 있는 바이러스의 타입
    static int S;   //  확인할 시간
    static int X;   //  확인할 바이러스의 X 좌표
    static int Y;   //  확인할 바이러스의 Y 좌표

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) input(i, j, Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
        while (S --> 0) {
            spread();
        }
        System.out.println(map[X][Y]);
    }

    private static void spread() {
        LinkedList<Node> linkedList = new LinkedList<>();
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = node.x + xArr[i];
                int dy = node.y + yArr[i];
                if (isValidate(dx, dy)) {
                    linkedList.add(new Node(dx, dy, node.value));
                    map[dx][dy] = node.value;
                }
            }
        }
        while (!linkedList.isEmpty()) priorityQueue.offer(linkedList.pop());
    }

    private static boolean isValidate(int i, int j) {
        if (i >= N || j >= N || i < 0 || j < 0) return false;
        return map[i][j] == 0;
    }

    private static void input(int i, int j, int value) {
        if (value > 0) priorityQueue.offer(new Node(i, j, value));
        map[i][j] = value;
    }

    private static void display() {
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) System.out.print(map[i][j]);
        }
        System.out.println();
        priorityQueue.forEach(e -> {
            System.out.println(e.x + ":" + e.y + ":" + e.value);
        });
    }
}
