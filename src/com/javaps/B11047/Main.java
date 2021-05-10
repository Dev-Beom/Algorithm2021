package com.javaps.B11047;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // INPUT
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int tmp = K;
        int count = 0;

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        // CALCULATION
        for (int i = N; i > 0; i--) {
            while (tmp >= coins[i]) {
                tmp -= coins[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
