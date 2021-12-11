package com.javaps.B2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                priorityQueue.offer(Long.parseLong(st.nextToken()));
            }
        }

        for (int i= 0; i < N - 1; i++) {
            priorityQueue.poll();
        }
        System.out.println(priorityQueue.poll());
    }
}
