package com.javaps.B2960;

/*
 * 문제 유형 : 구현
 * 문제 난이도 : 실버 4
 * 풀이 시간 : 13분 45초
 * 제출 실패 횟수 : 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];

        Arrays.fill(arr, true);

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!arr[j])
                    continue;
                arr[j] = false;
                cnt++;
                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
