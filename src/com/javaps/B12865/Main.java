package com.javaps.B12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[][] DP;
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int productCnt = Integer.parseInt(st.nextToken());
        int bagMaxWeight = Integer.parseInt(st.nextToken());

        weights = new int[productCnt];
        values = new int[productCnt];

        DP = new Integer[productCnt][bagMaxWeight + 1];

        for (int i = 0; i < productCnt; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(knapsack(productCnt - 1, bagMaxWeight));
    }

    private static int knapsack(int productIdx, int currWeight) {
        if (productIdx < 0) return 0;
        if (DP[productIdx][currWeight] == null) {
            if (weights[productIdx] > currWeight) {
                DP[productIdx][currWeight] = knapsack(productIdx - 1, currWeight);
            } else {
                int prevSumWeight = knapsack(productIdx - 1, currWeight);
                int newSumWeight = knapsack(productIdx - 1, currWeight - weights[productIdx]) + values[productIdx];
                DP[productIdx][currWeight] = Math.max(prevSumWeight, newSumWeight);
            }
        }
        return DP[productIdx][currWeight];
    }
}
