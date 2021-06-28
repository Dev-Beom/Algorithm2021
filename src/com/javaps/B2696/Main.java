package com.javaps.B2696;

/*
 * 문제 유형 : 우선순위 큐
 * 문제 난이도 : 골드 2
 * 풀이 시간 : 35분 47초
 * 제출 실패 횟수 : 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int lineCnt = 0;

            sb.append(((M + 1) / 2) + "\n");

            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) st = new StringTokenizer(br.readLine());
                int data = Integer.parseInt(st.nextToken());
                if (maxHeap.size() == minHeap.size()) maxHeap.offer(data);
                else minHeap.offer(data);

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if (i % 2 == 0) {
                    if (lineCnt == 9 || i == M - 1) {
                        sb.append(maxHeap.peek()).append("\n");
                        lineCnt = 0;
                    } else {
                        sb.append(maxHeap.peek()).append(" ");
                    }
                    lineCnt++;
                }
            }
        }
        System.out.print(sb);
    }
}
