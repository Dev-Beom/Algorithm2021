package com.javaps.B11286;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int input;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input = Integer.parseInt(st.nextToken());

            if (input == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(input);
            }
        }
    }
}
