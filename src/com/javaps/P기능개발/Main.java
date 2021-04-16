//https://programmers.co.kr/learn/courses/30/lessons/42586

package com.javaps.P기능개발;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {

        //  디버깅용
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new Solution().solution(progress, speeds)));
    }


    public static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> progressesQueue = new LinkedList<>();
            Queue<Integer> speedsQueue = new LinkedList<>();
            ArrayList<Integer> answerList = new ArrayList<>();
            int size;
            int pItem;
            int sItem;
            int count = 0;

            // 큐에 넣음
            for (int i = 0; i < progresses.length; i++) {
                progressesQueue.add(progresses[i]);
                speedsQueue.add(speeds[i]);
            }

            // 프로그래스의 사이즈
            size = progresses.length;

            // 사이즈가 0보다 크면, 즉 작업해야할 요소가 남아있다면
            while (size > 0) {
                // 사이즈만큼 프로그래시스와 스피드에서 하나씩 뽑은다음 연산 후 다시 뒤에 넣어줌
                for (int i = 0; i < size; i++) {
                    pItem = progressesQueue.poll();
                    sItem = speedsQueue.poll();
                    pItem = pItem + sItem;
                    // 연산 후 100보다 커지면 100으로 고정
                    if (pItem > 100) {
                        pItem = 100;
                    }
                    progressesQueue.add(pItem);
                    speedsQueue.add(sItem);
                }

                // 한바퀴 돌고 나서 남은 작업량을 돌아보며 앞에서부터 100이면,
                for (int i = 0; i < size; i++) {
                    if (progressesQueue.peek() == 100) {
                        // 작업량, 속도 큐에서 뽑아버리고
                        progressesQueue.poll();
                        speedsQueue.poll();

                        // 당일 몇개나 배포 할 수 있는지 카운트를 증가시킴.
                        count++;
                    }
                }

                // 남은 작업량을 계산하기 위해 수행
                size = size - count;

                // 리스트에 0이 들어가는걸 방지
                if (count > 0)
                    answerList.add(count);
                // 초기화
                count = 0;
            }

            // Array List 를 array 로 변환시키는 작업
            int[] answer = new int[answerList.size()];
            int index = 0;
            for (int element : answerList) {
                answer[index++] = element;
            }
            return answer;
        }
    }
}
