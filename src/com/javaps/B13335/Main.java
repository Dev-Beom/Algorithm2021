package com.javaps.B13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> trucks = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trucks.offer(Integer.parseInt(st.nextToken()));
        int time = 0;
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<Integer>();
        for (int i = 0; i < w; i++) bridge.offer(0);
        while (!bridge.isEmpty()) {
            time++;
            bridgeWeight -= bridge.poll();
            if (!trucks.isEmpty()) {
                if (trucks.peek() + bridgeWeight <= L) {
                    bridgeWeight += trucks.peek();
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}