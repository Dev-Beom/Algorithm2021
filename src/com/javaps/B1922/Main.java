package com.javaps.B1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int N, M;
    static int[] parents;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }

        initVertex();
        Collections.sort(edgeList);
        System.out.println(getMSTMinCost());
    }

    private static int getMSTMinCost() {
        int minCost = 0;
        for (Edge edge : edgeList) {
            int start = find(edge.from);
            int end = find(edge.to);
            if (start == end) continue;
            union(edge.from, edge.to);
            minCost += edge.weight;
        }
        return minCost;
    }

    private static void initVertex() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int value) {
        if (value == parents[value]) return value;
        parents[value] = find(parents[value]);
        return parents[value];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parents[aRoot] = b;
    }
}
