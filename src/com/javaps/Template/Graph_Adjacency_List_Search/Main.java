package com.javaps.Template.Graph_Adjacency_List_Search;

// 그래프 인접 그래 탐색

/*
입력 값:
7 8
1 2
1 3
2 4
2 5
3 7
4 6
5 6
6 7
*/

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int start, end = 1;

        visited = new boolean[N + 1];

        // 반드시 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 자식이 여러개라면 노드 번호가 작은 것 먼저 방문하므로 오름차순으로 정렬.
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        System.out.println("그래프 DFS 방문 순서 : ");
        dfs(1);
        System.out.println();

        Arrays.fill(visited, false);

        System.out.println("그래프 BFS 방문 순서 : ");
        bfs(1);
    }

    static void dfs(int vertex) {
        int start = vertex;
        int end;

        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < graph.get(start).size(); i++) {
            end = graph.get(start).get(i);
            if (!visited[end]) {
                dfs(end);
            }
        }
    }

    static void bfs(int vertex) {
        int start = vertex;
        int end;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 0; i < graph.get(start).size(); i++) {
                end = graph.get(start).get(i);
                if (!visited[end]) {
                    visited[end] = true;
                    queue.offer(end);
                }
            }
        }
    }
}
