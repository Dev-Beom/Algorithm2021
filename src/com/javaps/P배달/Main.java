package com.javaps.P배달;
import java.util.*;
public class Main {


    class Edge {
        public int vertex;
        public int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    class Solution {

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            ArrayList<Edge>[] graph = new ArrayList[N + 1];

            for (int i = 0; i <= N; i++) graph[i] = new ArrayList<Edge>();

            int[] distance = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            int INF = Integer.MAX_VALUE;

            Arrays.fill(distance, INF);
            distance[1] = 0;

            for (int i = 0; i < road.length; i++) {
                int start = road[i][0];
                int end = road[i][1];
                int weight = road[i][2];
                graph[start].add(new Edge(end, weight));
                graph[end].add(new Edge(start, weight));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o1.weight, o2.weight);
                }
            });
            pq.offer(new Edge(1, 0));

            while(!pq.isEmpty()) {
                int current = pq.poll().vertex;

                for (Edge next : graph[current]) {
                    if (distance[next.vertex] > distance[current] + next.weight) {
                        distance[next.vertex] = distance[current] + next.weight;
                        pq.offer(next);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (distance[i] <= K) answer++;
                System.out.println(distance[i]);
            }


            return answer;
        }
    }
}
