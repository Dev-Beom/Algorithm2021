package com.javaps.B13305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // INIT VARIABLE
        int N = Integer.parseInt(st.nextToken());   // 도시의 개수
        int[] dist = new int[N - 1];                 // 도로의 길이
        int[] cost = new int[N];                      // 도시 별 기름 L 당 가격

        long sum = 0;

        // INPUT [lengths : 도로의 길이]
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        // INPUT [prices : 도시별 기름 L 당 가격]
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = cost[0]; // 이전까지의 과정 중 주유 최소 비용

        for (int i = 0; i < N - 1; i++) {
            // 현재 주유소가 이전 주유소의 기름보다 쌀 경우 minCost 값을 갱신
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * dist[i]);
        }
        System.out.println(sum);
    }
}
