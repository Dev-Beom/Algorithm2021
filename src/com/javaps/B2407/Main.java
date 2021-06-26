package com.javaps.B2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    private static BigInteger[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DP = new BigInteger[n + 1][m + 1];
        System.out.println(recursion(n, m));
    }

    private static BigInteger recursion(int n, int m) {
        if (n == m || m == 0) return BigInteger.ONE;
        if (DP[n][m] != null) return DP[n][m];
        DP[n][m] = new BigInteger("0");
        return DP[n][m] = DP[n][m].add(recursion(n - 1, m - 1)).add(recursion(n - 1, m));
    }
}
