package com.javaps.B1003;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Integer[][] dp;

    public static Integer[] fibonacci(int N) {
        // N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
        if (dp[N][0] == null || dp[N][1] == null) {
            // 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        // N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
        return dp[N];
    }


    public static void main(String[] args) throws IOException {
        // INIT VARIABLE
        st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        dp = new Integer[41][2];

        dp[0][0] = 1;   //  N = 0 일 때의 0의 호출 횟수
        dp[0][1] = 0;   //  N = 0 일 때의 1의 호출 횟수
        dp[1][0] = 0;   //  N = 1 일 때의 0의 호출 횟수
        dp[1][1] = 1;   //  N = 1 일 때의 1의 호출 횟수

        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}