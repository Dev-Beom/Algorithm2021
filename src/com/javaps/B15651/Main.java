package com.javaps.B15651;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;

    static int[] arr;
    static StringBuilder sb  = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];

        func(0);
        System.out.println(sb);
    }

    public static void func(int depth) {
        // 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열을 출력.
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;         // 해당 노드를 방문 상태로 변경
            func(depth + 1);    // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀 호출
        }
    }
}