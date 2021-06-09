package com.javaps.B7562;

import java.util.*;
import java.io.*;

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int L;
    static int[][] map;
    static boolean[][] isVisited;

    static int gx;
    static int gy;
    static int sx;
    static int sy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Location> locations = new LinkedList<>();
        int TC = Integer.parseInt(st.nextToken());

        for (int idx = 0; idx < TC; idx++) {
            L = Integer.parseInt(br.readLine());    // 한변의 길이
            map = new int[L][L];
            isVisited = new boolean[L][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    map[i][j] = 0;
                    isVisited[i][j] = false;
                }
            }

            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            int[] xArr = {1, 2, 2, 1, -1, -2, -2, -1};
            int[] yArr = {-2, -1, 1, 2, 2, 1, -1, -2};

            locations.clear();
            locations.add(new Location(gx, gy));
            isVisited[gx][gy] = true;

            int rx;
            int ry;
            while (!locations.isEmpty()) {
                Location location = locations.poll();
                int dx = location.x;
                int dy = location.y;
                if (dx == sx && dy == sy) {
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = dx + xArr[i];
                    int ny = dy + yArr[i];
                    if (nx < 0 || nx >= L || ny < 0 || ny >= L) {
                        continue;
                    }
                    if (!isVisited[nx][ny]) {
                        locations.add(new Location(nx, ny));
                        isVisited[nx][ny] = true;
                        map[nx][ny] = map[dx][dy] + 1;
                    }
                }
            }
            System.out.println(map[sx][sy]);
        }
    }
}
