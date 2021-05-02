package com.javaps.P프린터;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main_ {

    public static void main(String[] args) throws IOException {

        // 디버깅용
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(new Solution().solution(priorities, location));
    }

    public static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int print = 0;
            int max = 0;
            int count = 0;

            Queue<Integer> prioritiesQueue = new LinkedList<>();

            for (int priority : priorities) {
                prioritiesQueue.add(priority);
            }
            while (prioritiesQueue.size() > 0) {

//                System.out.println(prioritiesQueue);
                print = prioritiesQueue.peek();
                max = prioritiesQueue.stream().max(Integer::compare).orElse(-1);
                if (print < max) {
                    prioritiesQueue.add(prioritiesQueue.poll());
                    if (location > 0) location--;
                    else location = prioritiesQueue.size() - 1;
                } else {
//                    System.out.println(prioritiesQueue.poll());
                    prioritiesQueue.poll();
                    if (location > 0) location--;
                    else break;
                }
                count++;
            }
            answer = count;
            return answer;
        }
    }
}
