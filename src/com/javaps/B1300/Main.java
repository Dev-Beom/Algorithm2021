package com.javaps.B1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int low = 1, high = K;
        int result = -1;


        while (low <= high) {
            int cnt = 0;
            int mid = (low + high) / 2;

            for (int i = 1; i <= N; i++) cnt += Math.min(mid / i, N);
            if (cnt < K) low = mid + 1;
            else {
                result = mid;
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}