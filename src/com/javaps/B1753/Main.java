package com.javaps.B1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    public int vertex;
    public int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int K = Integer.parseInt(br.readLine());    // 시작 정점의 번호

        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            graph[i] = new ArrayList<Edge>();

        int[] distance = new int[V + 1];
        boolean[] check = new boolean[V + 1];
        int INF = 10 * (V - 1) + 1;

        Arrays.fill(distance, INF);
        distance[K] = 0;

        for (int tc = 0; tc < E; tc++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        priorityQueue.offer(new Edge(K, 0));

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll().vertex;
            if (check[current]) continue;
            check[current] = true;

            for (Edge next : graph[current]) {
                if (distance[next.vertex] > distance[current] + next.weight) {
                    distance[next.vertex] = distance[current] + next.weight;
                    priorityQueue.offer(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }

    }
}
