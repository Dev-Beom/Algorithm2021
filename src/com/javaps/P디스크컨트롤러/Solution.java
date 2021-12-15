package com.javaps.P디스크컨트롤러;

import java.util.PriorityQueue;

class Solution {
    static class Task {
        int requestTime, runningTime;
        Task(int requestTime, int runningTime) {
            this.requestTime = requestTime;
            this.runningTime = runningTime;
        }
    }

    static PriorityQueue<Task> readyQueue = new PriorityQueue<>((o1, o2) -> o1.requestTime - o2.requestTime);
    static PriorityQueue<Task> jobQueue = new PriorityQueue<>((o1, o2) -> o1.runningTime - o2.runningTime);

    public int solution(int[][] jobs) {
        for (int[] job : jobs) {
            int requestTime = job[0];
            int runningTime = job[1];
            readyQueue.offer(new Task(requestTime, runningTime));
        }

        int cnt = 0, sum = 0, time = 0;

        while (cnt < jobs.length) {
            while (!readyQueue.isEmpty() && time >= readyQueue.peek().requestTime) {
                jobQueue.offer(readyQueue.poll());
            }

            if (!jobQueue.isEmpty()) {
                Task task = jobQueue.poll();
                sum += task.runningTime + (time - task.requestTime);
                time += task.runningTime;
                cnt++;
                continue;
            }
            time++;
        }
        return sum / cnt;
    }
}