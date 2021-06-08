package com.javaps.B9461;

import java.io.*;

public class Main {
    static Long[] sequence = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        sequence[0] = 0L;
        sequence[1] = 1L;
        sequence[2] = 1L;
        sequence[3] = 1L;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(padovan(N));
        }
    }

    public static long padovan(int N) {
        if (sequence[N] == null) {  // 탐색하지 않은 인덱스인 경우
            sequence[N] = padovan(N - 2) + padovan(N - 3);
        }
        return sequence[N];
    }
}
