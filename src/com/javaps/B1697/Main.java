package com.javaps.B1697;

import java.io.*;
import java.util.*;

public class Main {

    static int N; // 수빈이의 위치
    static int K; // 동생의 위치

    // 방문 확인용 배열
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 바로 잡은 경우
        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }


    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        // 첫 움직임
        check[num] = 1;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    // 앞으로 걷는 경우 ( + 1 )
                    next = tmp + 1;
                } else if (i == 1) {
                    // 뒤로 걷는 경우 ( - 1)
                    next = tmp - 1;
                } else {
                    // 순간이동 하는 경우 ( * 2 )
                    next = tmp * 2;
                }

                // 잡았을 때
                if (next == K) {
                    // 현재의 위치를 출력
                    System.out.println(check[tmp]);
                    return;
                }

                // 0보다 크고, 최대 길이를 넘지 않으며 0이 아닌 경우
                if (next >= 0 && next < check.length && check[next] == 0) {
                    // 방문한 위치인 next를 기억하고
                    queue.add(next);

                    // 거리를 기억한다.
                    check[next] = check[tmp] + 1;
                }
            }
        }
    }
}
