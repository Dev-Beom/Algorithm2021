package com.javaps.P다리를지나는트럭;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        //  디버깅용
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
    }

    public static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            int firstWaitTruck = 0;
            int nowWeight = 0;
            int tic = 0;
            int firstWaitTruckCount = truck_weights.length;
            int finishedTruckCount = 0;
            int pollData = 0;

            Queue<Integer> finishedTruck = new LinkedList<>();
            Queue<Integer> inBridgeTruck = new LinkedList<>();
            Queue<Integer> waitTruck = new LinkedList<>();

            for (int i = 0; i < firstWaitTruckCount; i++) {
                waitTruck.add(truck_weights[i]);
            }
            while (!waitTruck.isEmpty() || !inBridgeTruck.isEmpty()) {
                time++;
                if (tic == bridge_length) {
                    pollData = inBridgeTruck.poll();
                    finishedTruck.add(pollData);
                    nowWeight -= pollData;

                    tic = 0;
                    finishedTruckCount++;
                }
                if (!waitTruck.isEmpty()) {
                    firstWaitTruck = waitTruck.peek();
                    if (nowWeight + firstWaitTruck <= weight) {
                        pollData = waitTruck.poll();
                        inBridgeTruck.add(pollData);
                        nowWeight += pollData;
                    }
                }
                tic++;
            }
            return time;
        }
    }
}
