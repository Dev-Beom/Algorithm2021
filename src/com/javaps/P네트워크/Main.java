package com.javaps.P네트워크;

import java.util.*;

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static Queue<Integer> queue = new LinkedList<>();

    static int[][] map;
    static boolean[] visited;
    static int col, row;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        col = computers.length;
        row = computers[0].length;
        map = new int[col][row];

        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++)
            for (int j = 0; j < computers[0].length; j++)
                map[i][j] = computers[i][j];


        for (int tc = 0; tc < computers.length; tc++)
            if (!visited[tc])
                answer += bfs(tc);


        return answer;
    }

    static int bfs(int x) {
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < col; j++) {
                if (map[j][i] == 1 && i != j && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
        return 1;
    }

}
