package com.javaps.B11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        int cnt = 1, Max = 1;
        long ans = cards[0];
        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1]) cnt += 1;
            else cnt = 1;
            if (Max < cnt) {
                Max = cnt;
                ans = cards[i];
            }
        }
        System.out.println(ans);
    }
}
