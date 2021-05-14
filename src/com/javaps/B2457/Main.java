package com.javaps.B2457;

import java.io.*;
import java.util.*;

public class Main {

    public static int transDateToInteger(String month, String day) {
        return (Integer.parseInt(month) * 100) + Integer.parseInt(day);
    }

    public static void main(String[] args) throws IOException {

        final int START_DATE = 301;
        final int END_DATE = 1201;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> flowers = new HashMap<>();

        int count = 0;

        // data 를 입력받아서 HashMap 에 저장
        // 이 때, key 는 중복될 수 있으므로, 중복되는 경우 end_date(지는 날짜)가 더 긴 flower 가 put 되어야 한다.
        for (int i = 0; i < N; i++) {
            StringTokenizer raw = new StringTokenizer(br.readLine());
            int start = transDateToInteger(raw.nextToken(), raw.nextToken());
            int end = transDateToInteger(raw.nextToken(), raw.nextToken());

            if (flowers.get(start) == null || flowers.get(start) < end) {
                // 새로운 end 가 기존의 end 보다 길다면
                flowers.put(start, end);
            }
        }

        boolean flag = false;
        int current = START_DATE; // 기준. 초기값 : 301(3/1)
        while (current < END_DATE) { // 기준이 11월 20일을 넘어서지 않으면

            int max = current;

            for (int key : flowers.keySet()) { // 전체 꽃들을 돌면서
                if (key <= current && max < flowers.get(key)) {
                    // 기준 날짜보다 먼저 피는(기준 날짜 포함) 꽃들 중에서, 가장 멀리 있는 꽃을 찾는다.
                    max = flowers.get(key); // 최대를 현재 꽃으로 갱신

                    flag = true;
                }
            }

            if (flag) { // 정상 처리되었다면, 가장 먼 날짜를 기준으로 변경
                current = max;
                flag = false;
                count++;
            } else {  // 기준이 변경되지 않았다면 count 를 초기화 하고 종료
                count = 0;
                break;
            }
        }
        System.out.println(count);
    }
}
