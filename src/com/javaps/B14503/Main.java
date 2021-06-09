package com.javaps.B14503;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 세로 크기
        int M = Integer.parseInt(st.nextToken());   // 가로 크기

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());   // 바라보고 있는 방향 ( 0 = 북, 1 = 동, 2 = 남, 3 = 서)

        st = new StringTokenizer(br.readLine());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = 0;
            }
        }
    }
}
