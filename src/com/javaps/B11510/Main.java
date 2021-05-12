package com.javaps.B11510;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // TEST CASE
        int T = Integer.parseInt(st.nextToken());

        // VARIABLE INITIALIZE
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            String tmp = br.readLine();
            int N = Integer.parseInt(tmp);
            int[] arr = new int[N];
            int sum = 0;
            StringTokenizer tmpSt = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int pushData = Integer.parseInt(tmpSt.nextToken());
                queue.add(pushData);
                arr[j] = pushData;
            }
            int pollCount = 0;
            while (!queue.isEmpty()) {
                int pollData = queue.poll();
                int max = 0;
                for (int j = pollCount; j < N; j++) {
                    if (arr[j] > max) max = arr[j];
                }
                if (pollData < max) {
                    sum += max - pollData;
                }
                pollCount++;
            }
            result.add(sum);
        }
        result.forEach(System.out::println);
    }
}
