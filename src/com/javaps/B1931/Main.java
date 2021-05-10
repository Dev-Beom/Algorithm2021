package com.javaps.B1931;
// 그리디

/*
시간표를 최대한 많이 배정하거나 선택하는 문제를 '활동 선택 문제(Activity Selection problem)'이라고 한다.
즉, 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택하는 문제.
이러한 문제들의 특징은 '한사람이 하나의 활동에 대해서만 작업할 수 있다' 라는 점이다.
즉, 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다는 것이다.
하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이고, 탐욕 선택이 이후의 결과에 영향을 미치지 않는다.

이전의 선택 결과가 이후의 결과에 영향을 미치지 않으려면, 먼저 '이전 선택의 종료 시간' 과 '이후 선택의 종료 시간' 이 서로 겹치지 않으면 된다.
그리고 최대한 많은 활동을 선택하려면 종료시간이 빨라야 할 수 밖에 없다.
정리해서, '서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다' 는 것이다.
이를 포인트로 종료시간을 기준으로 정렬한다. 그런 다음 이전 종료시간에 대해 겹치는 것들을 제외하고 남은 것들 중 선택하면 되는 것.

 */

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(tmp.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(tmp.nextToken()); // 종료시간
        }

        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료 시간이 같을 경우 시작시간이 빠른 순으로 정렬해야한다.
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < N; i++) {
            // 직전 종료 시간이 다음 회의 시작 시간보다 작거나 같으면 갱신
            if (prevEndTime <= time[i][0]) {
                prevEndTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}