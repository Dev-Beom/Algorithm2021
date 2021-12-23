package com.javaps.B1947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] DP = new long[1000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP[1] = 0;
        DP[2] = 1;
        for (int i = 3; i <= N; i++) {
            DP[i] = ((i - 1) * (DP[i - 1] + DP[i - 2])) % 1000000000;
        }
        System.out.println(DP[N]);
    }
}
