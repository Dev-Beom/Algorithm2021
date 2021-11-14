package com.javaps.Template.Graph_Dijkstra_Adjacency_Matrix_PQ;

import java.util.PriorityQueue;

class Graph {
    private int n;
    private int maps[][];

    public Graph(int n) {
        this.n = n;
        maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    class Node implements Comparable<Node> {
        private int weight;
        private int index;

        public Node(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.weight, node.weight);
        }
    }

    public void input(int i, int j, int weight) {
        maps[i][j] = weight;
        maps[j][i] = weight;
    }

    public void dijkstra(int v) {
        // 노드까지의 거리를 저장할 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        pq.offer(new Node(v, 0));
        distance[v] = 0;
        check[v] = true;
        printDistance(distance);

        // 연결 노드 distance 갱신
        for (int i = 0; i < n; i++) {
            if (!check[i] && maps[v][i] != Integer.MAX_VALUE) {
                distance[i] = maps[v][i];
                pq.offer(new Node(maps[v][i], i));
            }
        }
        printDistance(distance);

        // 최소비용을 구해가는 과정은 인접 행렬 때와 같고 최소 노드를 찾는 과정만 큐에서 꺼내는 과정으로 수정
        while (!pq.isEmpty()) {
            // 노드의 최솟값을 꺼낸다.
            Node node = pq.poll();
            int minIdx = node.index;

            // 다른 노드를 거쳐서 가는게 더 비용이 적은지 확인
            check[minIdx] = true;
            for (int i = 0; i < n; i++) {
                if (!check[i] && maps[minIdx][i] != Integer.MAX_VALUE) {
                    if (distance[minIdx] + maps[minIdx][i] < distance[i]) {
                        distance[i] = distance[minIdx] + maps[minIdx][i];
                        pq.offer(new Node(distance[i], i));
                    }
                }
            }
            printDistance(distance);
        }
    }

    public void printDistance(int[] distance) {
        for (int i = 0; i < n; ++i) {
            if (distance[i] == Integer.MAX_VALUE) System.out.print("∞ ");
            else System.out.print(distance[i] + " ");
        }
        System.out.println("");
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6); // 노드 수 만큼 그래프 생성
        // 시작, 끝, 간선 가중치 입력
        g.input(0, 1, 7);
        g.input(0, 2, 9);
        g.input(0, 5, 14);
        g.input(1, 2, 10);
        g.input(1, 3, 15);
        g.input(2, 3, 11);
        g.input(2, 5, 2);
        g.input(3, 4, 6);
        g.input(4, 5, 9);
        // 시작노드 기준 다익스트라 알고리즘 실행
        g.dijkstra(0);

    }
}
