package com.javaps.B1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int vertex, weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 개수 = 정점의 개수
        int M = Integer.parseInt(br.readLine());    // 버스의 개수 = 간선의 개수

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        int INF = 987654321;
        // INF는 항상 (간선 가중치의 최댓값) * (정점 개수 - 1) 보다 큰 값을 사용해야 한다.

        Arrays.fill(distance, INF);

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<Edge>();

        for (int tc = 0; tc < M; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        priorityQueue.offer(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll().vertex;
            if (visited[current]) continue;
            visited[current] = true;

            for (Edge next : graph[current]) {
                if (distance[next.vertex] > distance[current] + next.weight) {
                    distance[next.vertex] = distance[current] + next.weight;
                    priorityQueue.offer(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
        System.out.println(distance[end]);
    }
}
