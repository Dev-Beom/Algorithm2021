package com.javaps.B1946;

import java.io.*;
import java.util.*;

class Man {
    int one, two;

    Man(int one, int two) {
        this.one = one;
        this.two = two;
    }
}

public class Main {

    static int TC;
    static int N;
    static ArrayList<Man> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        TC = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken()); // 서류
                int tow = Integer.parseInt(st.nextToken()); // 면접

                list.add(new Man(one, tow));
            }
            sb.append(done()).append("\n");
            list = new ArrayList<>();
        }
        System.out.println(sb);
    }

    public static int done() {
        int count = N;
        Collections.sort(list, new Comparator<Man>() {
            // 1차 성적이 높은 순으로 정렬
            @Override
            public int compare(Man o1, Man o2) {
                return o1.one - o2.one;
            }
        });

        int two = list.get(0).two;  // 기준을 서류 1등의 면접 등수로 초기화
        for (int i = 1; i < list.size(); i++) {
            // 서류 등수가 높은 순으로 비교, 이전 데이터 중에 가장 높은 면접 등수만 비교
            if (two < list.get(i).two) {
                count--;    // 낮으면 탈락's
            } else {
                two = list.get(i).two;  // 높으면 최댓값 업뎃
            }
        }
        return count;
    }

    public static void display() {
        list.forEach(
                x -> {
                    System.out.println(x.one + ":" + x.two);
                }
        );
    }
}
