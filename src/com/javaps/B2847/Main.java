package com.javaps.B2847;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // INIT VARIABLE
        int N = Integer.parseInt(st.nextToken());
        int[] levels = new int[N];

        // 점수를 몇 번 감소시키면 되는지에 대한
        int count = 0;

        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            int calc;
            if (i > 0 && levels[i] <= levels[i - 1]) {
                calc = levels[i - 1] - levels[i] + 1;
                count += calc;
                levels[i - 1] -= calc;
            }
        }
        System.out.println(count);
    }
}
