package com.javaps.B1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N --> 0) {
           priorityQueue.offer(Long.parseLong(br.readLine()));
        }

        while (priorityQueue.size() > 1) {
            long p1 = priorityQueue.poll();
            long p2 = priorityQueue.poll();
            answer += p1 + p2;
            priorityQueue.offer(p1 + p2);
        }
        System.out.println(answer);
    }
}
