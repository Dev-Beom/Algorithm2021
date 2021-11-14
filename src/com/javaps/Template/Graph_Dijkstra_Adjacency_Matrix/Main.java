package com.javaps.Template.Graph_Dijkstra_Adjacency_Matrix;


class Graph {
    private final int n;          // 노드들의 수에요.
    private final int[][] map;    // 노드들 간의 가중치를 저장할변수에요.

    public Graph(int n) {
        this.n = n;
        map = new int[n][n];
        initMap();
    }

    // 인접행렬의 모든 값을 무한대로 초기화해요.
    private void initMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void input(int i, int j, int weight) {
        map[i][j] = weight;
        map[j][i] = weight;
    }

    public void dijkstra(int v) {
        int[] distance = new int[n];        // v 정점을 기준으로 최단 거리를 저장할 배열이에요.
        boolean[] check = new boolean[n];   // 해당 노드들을 방문했는지 확인할 변수에요.

        // 거리 값을 초기화 해요.
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 시작 노드 값을 초기화 해요.
        distance[v] = 0;
        check[v] = true;

        // 결과값을 출력해요.
        printDistance(distance);

        // 연결노드의 거리를 갱신해요.
        for (int i = 0; i < n; i++) {
            if (!check[i] && map[v][i] != Integer.MAX_VALUE) {
                distance[i] = map[v][i];
            }
        }

        for (int a = 0; a < n - 1; a++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;

            // 가장 가까운(비용이 적은) 노드를 찾아요.
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    if (distance[i] < min) {
                        min = distance[i];
                        minIdx = i;
                    }
                }
            }

            // 다른 노드를 거쳐서 가는게 더 가까운지(비용이 적은지) 확인해요.
            check[minIdx] = true;
            for (int i = 0; i < n; i++) {
                if (!check[i] && map[minIdx][i] != Integer.MAX_VALUE) {
                    if (distance[minIdx] + map[minIdx][i] < distance[i]) {
                        distance[i] = distance[minIdx] + map[minIdx][i];
                    }
                }
            }
            printDistance(distance);
        }
    }

    public void printDistance(int[] distance) {
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.print("∞");
            else System.out.print(distance[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);

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
