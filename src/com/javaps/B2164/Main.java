package com.javaps.B2164;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int queueSize = 0;
        for (int i = 1; i <= N; i++) {
            queue.add(i);
            queueSize++;
        }
        while (queueSize > 1) {
            queue.poll();
            queueSize--;
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
