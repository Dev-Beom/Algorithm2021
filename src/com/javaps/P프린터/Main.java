package com.javaps.P프린터;

import java.io.IOException;
import java.util.*;

public class Main {

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

//            Queue<Integer> prioritiesQueue = new LinkedList<>();
            Queue<HashMap<Integer, Integer>> docs = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {
                HashMap<Integer, Integer> prioritiesMap = new HashMap<>();
                prioritiesMap.put(i, priorities[i]);
                docs.add(prioritiesMap);
            }
            System.out.println(docs);

//            while (docs.size() > 0) {
//                print = docs.peek();
//                max = prioritiesQueue.stream().max(Integer::compare).orElse(-1);
//                if (print < max) {
//                    prioritiesQueue.add(prioritiesQueue.poll());
//                    if (location > 0) location--;
//                    else location = prioritiesQueue.size() - 1;
//                } else {
//                    prioritiesQueue.poll();
//                    if (location > 0) location--;
//                    else break;
//                }
//                count++;
//            }
            answer = count;
            return answer;
        }
    }
}
