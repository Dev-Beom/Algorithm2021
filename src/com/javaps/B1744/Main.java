package com.javaps.B1744;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sum = 0;

        // MAX HEAP
        PriorityQueue<Integer> arrMax = new PriorityQueue<>(Collections.reverseOrder());

        // MIN HEAP
        PriorityQueue<Integer> arrMin = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                arrMax.add(input);
            } else if (input <= 0) {
                // 0을 넣는 이유 ? 0과 -을 곱했을 때 -보다 0이 더 크니깐
                arrMin.add(input);
            }
        }

        while (!arrMax.isEmpty()) {
            if (arrMax.size() > 1) {
                int x = arrMax.poll();
                int y = arrMax.poll();
                // X와 Y가 1보다 크면 곱해서 더한다.
                if (x > 1 && y > 1) {
                    sum += x * y;
                } else {
                    sum += x + y;
                }
            } else {
                // 1개 밖에 안남았을 경우.
                sum += arrMax.poll();
            }
        }
        while (!arrMin.isEmpty()) {
            if (arrMin.size() > 1) {
                int x = arrMin.poll();
                int y = arrMin.poll();
                sum += x * y;
            } else {
                // 1개 밖에 안남았을 경우.
                sum += arrMin.poll();
            }
        }
        System.out.println(sum);
    }
}
