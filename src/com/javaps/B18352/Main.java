package com.javaps.B18352;

/*
 * 문제유형 : 다익스트라, BFS
 * 문제 난이도 : 실버 2
 * 풀이 시간 : 27분 33초
 * 제출 실패 횟수 : 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시의 개수 = 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 도로의 개수 = 간선의 개수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] distance = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        int INF = 987654321;
        Arrays.fill(distance, INF);
        distance[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        check[X] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);

                if (!check[next]) {
                    check[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean isOk = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                isOk = true;
            }
        }
        if (!isOk) System.out.println(-1);
    }
}
