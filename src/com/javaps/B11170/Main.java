package com.javaps.B11170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int i = N; i <= M; i++) {
                String int2String = String.valueOf(i);
                for (Character ch : int2String.toCharArray()) {
                    if (ch.equals('0')) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
