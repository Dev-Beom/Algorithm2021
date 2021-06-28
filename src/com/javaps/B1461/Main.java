package com.javaps.B1461;

/*
 * 문제 유형 : 그리디
 * 문제 난이도 : 골드 5
 * 풀이 시간 : 41분 43초
 * 제출 실패 횟수 : 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 책의 개수
        int M = Integer.parseInt(st.nextToken());   // 책의 위치

        int max = 0;
        int answer = 0;

        PriorityQueue<Integer> plus = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minus = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            if (data < 0) minus.offer(Math.abs(data));
            else plus.offer(data);
            max = Math.max(Math.abs(data), max);
        }

        while (!plus.isEmpty()) {
            int tmp = plus.poll();
            for (int i = 0; i < M - 1; i++) {
                plus.poll();
                if (plus.isEmpty()) break;
            }
            answer += tmp * 2;
        }

        while (!minus.isEmpty()) {
            int tmp = minus.poll();
            for (int i = 0; i < M - 1; i++) {
                minus.poll();
                if (minus.isEmpty()) break;
            }
            answer += tmp * 2;
        }
        answer -= max;
        System.out.println(answer);
    }
}