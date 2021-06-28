package com.javaps.B6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int z, x, y;
    int dist;

    Position(int z, int x, int y, int dist) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;

    static int[] zArr = {0, 0, 0, 0, 1, -1};
    static int[] xArr = {1, 0, -1, 0, 0, 0};
    static int[] yArr = {0, 1, 0, -1, 0, 0};

    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Position start = null;
            Position end = null;

            L = Integer.parseInt(st.nextToken());   // 빌딩의 층 수
            R = Integer.parseInt(st.nextToken());   // 한 층의 행
            C = Integer.parseInt(st.nextToken());   // 한 층의 열

            if (L == 0 && R == 0 && C == 0) break;
            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            String tmp;
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    tmp = br.readLine();
                    for (int j = 0; j < C; j++) {
                        char ch = tmp.charAt(j);
                        building[k][i][j] = ch;
                        if (ch == 'S') start = new Position(k, i, j, 0);
                        if (ch == 'E') end = new Position(k, i, j, 0);
                    }
                }
                br.readLine();
            }
            result.add(BFS(start, end));
        }
        result.forEach(System.out::println);
    }

    public static String BFS(Position start, Position end) {
        StringBuilder sb = new StringBuilder();
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.z][start.x][start.y] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            int nz = now.z;
            int nx = now.x;
            int ny = now.y;
            int nDist = now.dist;
            if (nz == end.z && nx == end.x && ny == end.y) {
                sb.append("Escaped in ").append(nDist).append(" minute(s).");
                return sb.toString();
            }
            for (int i = 0; i < 6; i++) {
                int dz = nz + zArr[i];
                int dx = nx + xArr[i];
                int dy = ny + yArr[i];
                if (isRangeAndCondition(dz, dx, dy)) {
                    queue.offer(new Position(dz, dx, dy, nDist + 1));
                    visited[dz][dx][dy] = true;
                }
            }
        }
        sb.append("Trapped!");
        return sb.toString();
    }

    public static boolean isRangeAndCondition(int z, int x, int y) {
        if (z >= L || z < 0 || x >= R || x < 0 || y >= C || y < 0) return false;
        if (building[z][x][y] == '#' || visited[z][x][y]) return false;
        return true;
    }

    public static void print() {
        for (int k = 0; k < L; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(building[k][i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
