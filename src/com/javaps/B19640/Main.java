package com.javaps.B19640;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static class Node {
        int idx, workingDays, toiletDegree, waitingLine;

        Node(int idx, int workingDays, int toiletDegree, int waitingLine) {
            this.idx = idx;
            this.workingDays = workingDays;
            this.toiletDegree = toiletDegree;
            this.waitingLine = waitingLine;
        }
    }

    static int N, M, K;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            int workingDay = o2.workingDays - o1.workingDays;
            if (workingDay == 0) {
                int toiletDegree = o2.toiletDegree - o1.toiletDegree;
                if (toiletDegree == 0) return o1.waitingLine - o2.waitingLine;
                return toiletDegree;
            }
            return workingDay;
        }
    });
    static LinkedList<Node>[] waitingLines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        waitingLines = new LinkedList[M];

        for (int i = 0; i < M; i++) waitingLines[i] = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int line = i % M;
            waitingLines[line].add(new Node(i, D, H, line));
        }

        for (int i = 0; i < M; i++) {
            if (waitingLines[i].size() == 0) break;
            Node n = waitingLines[i].remove(0);
            priorityQueue.offer(n);
        }

        int cnt = 0;
        while (!priorityQueue.isEmpty()) {
            cnt++;
            Node n = priorityQueue.poll();
            if (n.idx == K) break;
            if (waitingLines[n.waitingLine].size() == 0) continue;
            priorityQueue.add(waitingLines[n.waitingLine].remove(0));
        }
        System.out.println(cnt - 1);
    }
}
