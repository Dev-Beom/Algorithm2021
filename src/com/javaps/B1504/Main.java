package com.javaps.B1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int idx, weight;

    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int N, E;
    static int[] distance;
    static boolean[] check;
    static final int INF = 200000000;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(distance, INF);

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int r1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int r2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int min = (r1 >= INF && r2 >= INF) ? -1 : Math.min(r1, r2);
        System.out.println(min);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.idx;

            if (!check[curr]) {
                check[curr] = true;

                for (Node node : graph.get(curr)) {
                    if (!check[node.idx] && (distance[node.idx] > distance[curr] + node.weight)) {
                        distance[node.idx] = distance[curr] + node.weight;
                        pq.offer(new Node(node.idx, distance[node.idx]));
                    }
                }
            }
        }
        return distance[end];
    }
}
