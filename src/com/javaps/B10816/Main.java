package com.javaps.B10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        int M = Integer.parseInt(st.nextToken());
        int[] card1 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) card1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int[] card2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) card2[i] = Integer.parseInt(st.nextToken());

        for (Integer item : card1) map.put(item, map.getOrDefault(item, 0) + 1);
        for (Integer key : card2) {
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
