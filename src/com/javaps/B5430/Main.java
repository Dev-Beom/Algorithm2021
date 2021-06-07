package com.javaps.B5430;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> result = new LinkedList<>();

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 0; t < TC; t++) {

            // INPUT
            String command = br.readLine();
            int arraySize = Integer.parseInt(br.readLine());
            // int[] arr = new int[arraySize];
            String arrString = br.readLine().replaceAll("[^\\d]", " ");
            st = new StringTokenizer(arrString);
            for (int i = 0; i < arraySize; i++) {
                // arr[i] = Integer.parseInt(st.nextToken());
                deque.addLast(Integer.parseInt(st.nextToken()));
            }


            boolean isError = false;

            // COMMAND 실행
            boolean arrow = true;
            // arrow = true ->
            // arrow = false <-
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    arrow = !arrow;
                } else if (command.charAt(i) == 'D') {
                    if (arrow) {
                        if (deque.isEmpty()) {
                            isError = true;
                            continue;
                        }
                        deque.pollFirst();
                    } else {
                        if (deque.isEmpty()) {
                            isError = true;
                            continue;
                        }
                        deque.pollLast();
                    }
                }
            }
            if (isError) {
                sb.append("error").append('\n');
            } else {
                int size = deque.size();
                sb.append('[');
                for (int i = 0; i < size; i++) {
                    if (arrow) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if (i != size - 1) {
                        sb.append(',');
                    }
                }
                sb.append(']').append('\n');
            }
        }
        System.out.println(sb);
    }
}
