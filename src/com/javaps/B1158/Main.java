package com.javaps.B1158;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        int popData = 0;
        
        // INIT
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // Logic
        while (result.size() < N && !queue.isEmpty()) {
            for (int i = 0; i < K; i++) {
                popData = queue.poll();
                if (i != K - 1) {
                    queue.add(popData);
                }
            }
            result.add(popData);
        }

        // Display
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.toArray()[i]);
            if (i != result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
