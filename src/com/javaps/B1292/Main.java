package com.javaps.B1292;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[B + 1];

        int idx = 0;
        int sum = 0;

        for (int i = 1; i <= B / 2 + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.length <= idx) {
                    break;
                }
                arr[idx] = i;
                idx++;

            }
        }

        for (int i = A - 1; i < B; i++) {
            sum += arr[i];
        }
        System.out.println(sum );
    }
}
