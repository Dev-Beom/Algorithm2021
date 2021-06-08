package com.javaps.B1904;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // 배열들을 -1 로 초기화
        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(N));

    }

    public static int Tile(int N) {
        if (dp[N] == -1) {  // 해당 배열에 값이 없을 경우 재귀 호출
            dp[N] = (Tile(N - 1) + Tile(N - 2)) % 15746;
        }
        return dp[N];
    }
}
