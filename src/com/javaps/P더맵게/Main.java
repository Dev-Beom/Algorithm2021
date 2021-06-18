package com.javaps.P더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (Integer e : scoville) {
            pq.add(e);
        }

        while (pq.peek() <= K) {
            if (pq.size() == 1) {
                return -1;
            }
            int a = pq.poll();
            int b = pq.poll();


            int result = a + (b * 2);

            pq.offer(result);
            answer ++;
        }
        return answer;
    }
}