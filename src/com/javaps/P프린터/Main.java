package com.javaps.P프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 프린트 큐에 아이템을 넣습니다. 넣으면서 최대값을 갱신합니다.
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (Integer item : priorities) {
            queue.offer(item);
            max = max < item ? item : max;
        }

        while (true) {
            int data = queue.peek();
            int queueSize = queue.size();
            max = getMax(queue);
            if (location == 0) {
                // 원하는 로케이션이 맨 앞으로 왔으면,
                location = queueSize - 1;
                if (data < max) queue.offer(queue.poll());
                else if (data == max) {
                    break;
                }
            } else {
                location--;
                if (data == max) {
                    queue.poll();
                    answer++;
                } // 우선순위가 가장 높은 값이면 인쇄합니다.
                else queue.offer(queue.poll());
                max = 0;
            }
        }
        return answer;
    }

    static int getMax(Queue<Integer> queue) {
        int max = 0;
        for (Integer item : queue) {
            max = max < item ? item : max;
        }
        return max;
    }
}