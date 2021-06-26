package com.javaps.B5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] depth;
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 동기의 수
        int m = Integer.parseInt(br.readLine());    // 리스트의 길이

        visited = new boolean[n + 1];
        depth = new int[n + 1];
        cnt = 0;

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int tc = 0; tc < m; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i <= n; i++)
            Collections.sort(graph.get(i));

        bfs(1);
        for (Integer e : depth) {
            if (e < 3 && e != 0) cnt++;
        }
        System.out.println(cnt);
    }

    private static void bfs(int vertex) {
        int start = vertex;
        int end;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        depth[start] = 0;

        while (!queue.isEmpty()) {
            start = queue.poll();
            for (int i = 0; i < graph.get(start).size(); i++) {
                end = graph.get(start).get(i);
                if (!visited[end]) {
                    visited[end] = true;
                    queue.offer(end);
                    depth[end] = depth[start] + 1;
                }
            }
        }
    }
}
