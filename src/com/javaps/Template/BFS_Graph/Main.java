package com.javaps.Template.BFS_Graph;

/*

입력 값:
7
8
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

    static int[][] map;
    static boolean[] visited;

    static StringTokenizer st;
    static int N, M, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1];

        // 그래프 정보 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }
        System.out.println("그래프 BFS 방문 순서 : ");
        bfs(1);
    }

    static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int i = 1; i <= N; i++) {

                // 다음 정점과 연결되어 있고 아직 방문하지 않았다면
                if (map[x][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
