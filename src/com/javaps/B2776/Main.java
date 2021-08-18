package com.javaps.B2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            int cnt1 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt1; i++) {
                map.put(Integer.parseInt(st.nextToken()), 1);
            }

            int cnt2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt2; i++) {
                int value = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
                sb.append(value);
                if (i != cnt2 - 1) sb.append('\n');
            }
            System.out.println(sb);
        }
    }
}
