package com.javaps.B15903;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 카드의 갯수
        int M = Integer.parseInt(st.nextToken());   // 합체를 몇번하는가

        PriorityQueue<Long> cards = new PriorityQueue<>(); // 카드

        StringTokenizer tmp = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.add(Long.parseLong(tmp.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long x = cards.isEmpty() ? 0 : cards.poll();
            long y = cards.isEmpty() ? 0 : cards.poll();
            cards.add(x + y);
            cards.add(x + y);
        }

        long sum = 0;
        for (long e : cards) {
            sum += e;
        }
        System.out.println(sum);
    }
}
