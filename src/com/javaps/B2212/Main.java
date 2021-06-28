package com.javaps.B2212;

/*
 * 문제 유형 : 그리디
 * 문제 난이도 : 골드 5
 * 풀이 시간 : 9분 53초
 * 제출 실패 횟수 : 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 센서의 개수
        int K = Integer.parseInt(br.readLine());    // 집중국의 개수

        int[] arr = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length - 1; i++)
            priorityQueue.add(Math.abs(arr[i] - arr[i + 1]));
        for (int i = 0; i < arr.length - K; i++) {
            sum += priorityQueue.poll();
        }
        System.out.println(sum);
    }
}
