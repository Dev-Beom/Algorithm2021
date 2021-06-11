package com.javaps.B1010;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] DP = new int[30][30];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            // M 개중 N 개를 뽑는 경우이므로 nCr 에서 n = M, r = N 이다.
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(combination(M, N)).append('\n');
        }
        System.out.println(sb);
    }

    static int combination(int n, int r) {
        // 이미 풀린 경우 바로 반환
        if (DP[n][r] > 0) {
            return DP[n][r];
        }

        if (n == r || r == 0) {
            return DP[n][r] = 1;
        }

        return DP[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
