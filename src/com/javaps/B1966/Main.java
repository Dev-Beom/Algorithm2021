package com.javaps.B1966;

import java.util.*;
import java.io.*;

class Document {
    final int id;
    final int value;

    Document(int id, int value) {
        this.id = id;
        this.value = value;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int TC = Integer.parseInt(st.nextToken());

        int N;  // 문서의 갯수
        int M;  // 몇 번재로 인쇄되었는지 궁금한 문서가 현재 Queue 에서 몇 번째에 놓여 있는지
        int[] answer = new int[TC];
        int max = 0;

        for (int loop = 0; loop < TC; loop++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int loopp = 0; loopp < N; loopp++) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(new Document(loopp, value));
                priorityQueue.add(value);
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                Document queuePoll = queue.poll();
                int priorityQueuePoll = priorityQueue.poll();
                if (queuePoll.value < priorityQueuePoll) {
                    queue.add(queuePoll);
                    priorityQueue.add(priorityQueuePoll);
                } else {
                    cnt++;
                    if (queuePoll.id == M) {
                        answer[loop] = cnt;
                    }
                }

            }
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
