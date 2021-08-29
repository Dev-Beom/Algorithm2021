package com.javaps.B14923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, cnt;

    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static Node Start, End;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 시작 위치
        st = new StringTokenizer(br.readLine());
        Start = new Node(getIntToken(st) - 1, getIntToken(st) - 1, 0);

        // 탈출 위치
        st = new StringTokenizer(br.readLine());
        End = new Node(getIntToken(st) - 1, getIntToken(st) - 1, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(st);
            }
        }

        System.out.println(BFS());
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int BFS() {
        int time = 0;
        // [마법 사용 횟수][세로][가로]
        boolean[][][] visited = new boolean[2][N][M];
        Queue<Node> queue = new LinkedList<>();

        queue.add(Start);
        visited[0][Start.x][Start.y] = true;

        while (!queue.isEmpty()) {
            ++time;
            int size = queue.size();

            while (size-- > 0) {
                Node curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (!isRange(nx, ny)) continue;

                    if (map[nx][ny] == 1) { // 벽인 경우
                        // 마법을 사용할 수 있고, 방문하지 않았으면
                        if (curr.cnt == 0 && !visited[curr.cnt + 1][nx][ny]) {
                            if (nx == End.x && ny == End.y) return time;
                            queue.add(new Node(nx, ny, curr.cnt + 1));
                            visited[curr.cnt + 1][nx][ny] = true;
                        }
                    } else {    // 벽이 아닌 경우
                        if (!visited[curr.cnt][nx][ny]) {
                            if (nx == End.x && ny == End.y) return time;
                            queue.add(new Node(nx, ny, curr.cnt));
                            visited[curr.cnt][nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;  // 탈출을 할 수 없는 경우
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
