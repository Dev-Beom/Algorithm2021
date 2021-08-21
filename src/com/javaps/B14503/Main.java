package com.javaps.B14503;

import java.util.*;
import java.io.*;

public class Main {
    static int N;   // 세로 크기
    static int M;   // 가로 크기

    static int R;
    static int C;
    static int D;   // 바라보고 있는 방향 ( 0 = 북, 1 = 동, 2 = 남, 3 = 서)

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로 크기
        M = Integer.parseInt(st.nextToken());   // 가로 크기

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());   // 바라보고 있는 방향 ( 0 = 북, 1 = 동, 2 = 남, 3 = 서)

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //  북, 동, 남, 서
        int[] cArr = {-1, 0, 1, 0};
        int[] rArr = {0, 1, 0, -1};

        int nC = C;
        int nR = R;

        int count = 0;
        loop:
        while (true) {
            display();

            if (map[nC][nR] == 0) {
                map[nC][nR] = 2;
                count++;
            }
            for (int i = 0; i < 4; i++) {
                D = D - 1 < 0 ? 3 : D - 1;
                int xC = cArr[D];
                int xR = rArr[D];
                if (isRange(xC, xR) && map[xC][xR] == 0) {
                    nC = nC + cArr[D];
                    nR = nR + rArr[D];
                    break;
                }
                if (i == 3) {
                    switch (D) {
                        case 0:
                            nC = nC + cArr[2];
                            nR = nR + rArr[2];
                            break;
                        case 1:
                            nC = nC + cArr[3];
                            nR = nR + rArr[3];
                            break;
                        case 2:
                            nC = nC + cArr[0];
                            nR = nR + rArr[0];
                            break;
                        case 3:
                            nC = nC + cArr[1];
                            nR = nR + rArr[1];
                            break;
                    }
                    if (nC < 0 || nC >= N || nR < 0 || nR >= M || map[nC][nR] == 1) {
                        System.out.println(count);
                        break loop;
                    }
                }
            }
        }
    }

    static boolean isRange(int c, int r) {
        return c >= 0 && c < N && r >= 0 && r < M;
    }


    static void display() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
