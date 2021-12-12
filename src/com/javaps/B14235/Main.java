package com.javaps.B14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> gift = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 0) {
                if (gift.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(gift.poll());
                }
            } else {
                for (int i = 0; i < command; i++) {
                    gift.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
