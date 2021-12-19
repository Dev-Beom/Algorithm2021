package com.javaps.B12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx, time;

        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    final static int MAX_RANGE = 100000;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());


        System.out.println(from > to ? from - to : BFS(from, to));
        System.out.println(cnt);
    }

    private static int BFS(int from, int to) {
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[MAX_RANGE + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(from, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.idx] = true;

            if (node.idx == to) {
                if (min > node.time) min = node.time;
                else if (min == node.time) cnt++;
                continue;
            }
            if (node.idx * 2 <= MAX_RANGE && !visited[node.idx * 2]) queue.offer(new Node(node.idx * 2, node.time + 1));
            if (node.idx + 1 <= MAX_RANGE && !visited[node.idx + 1]) queue.offer(new Node(node.idx + 1, node.time + 1));
            if (node.idx - 1 >= 0 && !visited[node.idx - 1]) queue.offer(new Node(node.idx - 1, node.time + 1));
        }
        return min;
    }
}