package com.javaps.B2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int pay;
    int day;

    Node(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Node node) {
        if (node.pay > this.pay) { // pay가 높은게 우선순위가 높다
            return 1;
        } else if (node.pay == this.pay) {
            if (node.day < this.day) { // 같은 pay면 day가 낮은게 우선순위가 높다.
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    static int n;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int res = 0;
        n = Integer.parseInt(st.nextToken());
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            maxDay = Math.max(day, maxDay);
            priorityQueue.add(new Node(pay, day));
        }
        checked = new boolean[maxDay + 1];

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (int i = node.day; i >= 1; i--) {
                if (!checked[i]) {
                    checked[i] = true;
                    res += node.pay;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
