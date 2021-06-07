package com.javaps.B11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // INIT VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int idx = 0;

        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        // INPUT
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // LOGIC
        while (!queue.isEmpty()) {
            idx++;
            int poll = queue.poll();
            if (idx == M) {
                idx = 0;
                result.add(poll);
            } else {
                queue.add(poll);
            }
        }

        // DISPLAY
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
