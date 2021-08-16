package com.javaps.B14719;


/**
 * 더 큰 건물들 사이에 끼어 있으면 빗물이 담긴다.
 *
 * 1. 현재 인덱스의 왼쪽에서 가장 높은 건물의 높이를 구한다.
 * 2. 현재 인덱스의 오른쪽에서 가장 높은 건물의 높이를 구한다.
 * 3. 그중 더 낮은 건물의 높이를 구한다.
 * 4. 3번에서 구한 높이에서 현재 인덱스에 있는 건물의 높이를 뺀다.
 * 5. 위의 과정을 1번째, 마지막을 제외하고 현재 인덱스에서 담길 수 있는 빗물의 양을 합한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static int result, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        map = new int[W];
        result = left = right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) map[i] = Integer.parseInt(st.nextToken());

        // 인덱스마다 모이는 빗물 계산
        // 예외> 1번째 기둥과 마지막 기둥의 위치는 제외한다.
        for (int i = 1; i < W - 1; i++) {
            left = right = 0;
            // 왼쪽에서 가장 높은 건물의 높이
            for (int j = 0; j < i; j++) left = Math.max(map[j], left);
            // 오른쪽에서 가장 높은 건물의 높이
            for (int j = i + 1; j < W; j++) right = Math.max(map[j], right);
            // 더 낮은 건물을 기준으로 현재 인덱스에 모이는 빗물
            if (map[i] < left && map[i] < right) result += Math.min(left, right) - map[i];
        }
        System.out.println(result);
    }
}
