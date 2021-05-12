package com.javaps.B11510;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // TEST CASE
        int T = Integer.parseInt(st.nextToken());

        // VARIABLE INITIALIZE
        long [] result = new long[T];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] stock = new long[N];
            long max = 0;
            StringTokenizer tmpSt = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(tmpSt.nextToken());
            }

            for (int j = N - 1; j >= 0; j--) {
                if (stock[j] > max) {
                    max = stock[j];
                } else {
                    result[i] += (max - stock[j]);
                }
            }
        }
        for (long i : result) {
            System.out.println(i);
        }
    }
}
