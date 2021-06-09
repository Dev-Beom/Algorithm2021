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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Location> locations = new LinkedList<>();
        int TC = Integer.parseInt(st.nextToken());

        for (int idx = 0; idx < TC; idx++) {
            int L = Integer.parseInt(br.readLine());    // 한변의 길이
            int[][] map = new int[L][L];
            int[][] isVisited = new int[L][L];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    map[i][j] = 0;
                    isVisited[i][j] = 0;
                }
            }
            st = new StringTokenizer(br.readLine());
            locations.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            st = new StringTokenizer(br.readLine());
            int gx = Integer.parseInt(st.nextToken());
            int gy = Integer.parseInt(st.nextToken());

            int xArr = {1, 0, -1, 0};
            

            while (!locations.isEmpty()) {

            }
        }
    }
}
