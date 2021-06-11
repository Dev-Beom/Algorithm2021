package com.javaps.Template.DP_BottomUP;

public class Main {

    static long[] dp = new long[100];

    static long dp(int x) {
        if (x == 1) return 1;
        if (x == 2) return 1;
        if (dp[x] != 0) return dp[x];
        return dp[x] = dp(x - 1) + dp(x - 2);
    }

    public static void main(String[] args) {
        System.out.println(dp(50));
    }
}
