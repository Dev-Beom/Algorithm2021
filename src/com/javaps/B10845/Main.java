package com.javaps.B10845;

import java.util.*;
import java.io.*;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int value = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            String order = tmp.nextToken();

            switch (order) {
                case "push":
                    value = Integer.parseInt(tmp.nextToken());
                    queue.add(value);
                    break;
                case "pop":
                    if (queue.isEmpty()) System.out.println(-1);
                    else {
                        value = queue.poll();
                        System.out.println(value);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty()) System.out.println(-1);
                    else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) System.out.println(-1);
                    else {
                        System.out.println(queue.stream().toArray()[queue.size() - 1]);
                    }
                    break;
            }
        }
    }
}
