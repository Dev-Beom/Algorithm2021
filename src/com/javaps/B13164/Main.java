package com.javaps.B13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 원생의 수를 나타내는 자연수
        int K = Integer.parseInt(st.nextToken());   // 나누려고 하는 조의 개수를 나타내는 자연수

        int[] child = new int[N];
        int[] different = new int[N - 1];
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) child[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) different[i] = child[i + 1] - child[i];

        Arrays.sort(different);

        for (int i = 0; i < N - K; i++) result += different[i];
        System.out.println(result);
    }
}
