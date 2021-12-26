package com.javaps.B9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] DP = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;


        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(getCase(N));
        }
    }

    private static int getCase(int N) {
        if (N <= 2) return DP[N];
        for (int i = 3; i <= N; i++) {
            if (DP[i] == 0) {
                DP[i] = DP[i - 3] + DP[i - 2] + DP[i - 1];
            }
        }
        return DP[N];
    }
}
