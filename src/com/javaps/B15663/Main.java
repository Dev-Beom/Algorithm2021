package com.javaps.B15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        recursion(0, sb);
        System.out.println(sb);
    }

    public static void recursion(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(" ");
            sb.append("\n");
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    int cnt = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (arr[i] == list.get(j)) cnt++;
                    }
                    if (cnt == 0) {
                        visited[i] = true;
                        result[depth] = arr[i];
                        list.add(arr[i]);
                        recursion(depth + 1, sb);
                        visited[i] = false;
                    } else {
                        continue;
                    }
                }
            }

        }
    }
}
