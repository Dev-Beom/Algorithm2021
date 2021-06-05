package com.javaps.B1463;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // LOGIC
        if (N == 1) System.out.println(0);
        else if (N == 2 || N == 3) System.out.println(1);
        else {
            int[] DP = new int[N + 1];

            for (int i = 1; i <= N; ++i) {
                DP[i] = Integer.MAX_VALUE;
            }

            DP[1] = 0;
            DP[2] = 1;
            DP[3] = 1;

            for (int i = 4; i <= N; i++) {
                if (i % 3 == 0) {
                    // 3 으로 나누어 떨어지면
                    DP[i] = Math.min(DP[i / 3] + 1, DP[i]);
                }
                if (i % 2 == 0) {
                    // 2 으로 나누어 떨어지면
                    DP[i] = Math.min(DP[i / 2] + 1, DP[i]);
                }
                DP[i] = Math.min(DP[i], DP[i - 1] + 1);
            }

            // DISPLAY
            System.out.println(DP[N]);
        }
    }
}
