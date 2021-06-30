package com.javaps.B4796;

/*
 * 문제 유형 : 그리디
 * 문제 난이도 : 실버 5
 * 풀이 시간 : 7분 3초
 * 제출 실패 횟수 : 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        while (true) {
            index++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int answer = 0;
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (isEnd(L, P, V)) return;
            answer = ((V / P) * L) + Math.min(L, (V % P));
            sb.append("Case ").append(index).append(": ");
            sb.append(answer);
            System.out.println(sb);
        }
    }

    public static boolean isEnd(int L, int P, int V) {
        return L == 0 && P == 0 && V == 0;
    }
}
