package com.javaps.P합승택시요금;

import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for (int i= 1; i <= n; i++) {
            Arrays.fill(graph[i], 20000001);
            graph[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int distance = fares[i][2];
            graph[from][to] = distance;
            graph[to][from] = distance;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return min;
    }
}
