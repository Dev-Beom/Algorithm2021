package com.javaps.B15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            // 깊이가 M이랑 같을 경우 출력
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // i 는 at 부터 탐색하도록 한다.
        for (int i = at; i <= N; i++) {
            // 현재 깊이를 index 로 하여 해당 위치에 i 값을 담는다.
            arr[depth] = i;

            // 재귀 호출:
            // 비내림차순임으로 중복 허용, i값을 인자로 넘겨 재귀 호출
            // i + 1 의 값을 넘겨주고, 깊이 또한 1 증가시켜 재귀 호출해준다.
            dfs(i, depth + 1);
        }
    }
}
