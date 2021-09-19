package com.javaps.P입실퇴실;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static Set<Integer> room = new HashSet<>();
    static HashMap<Integer, Integer> people = new HashMap<>();

    static Queue<Integer> enterQueue = new LinkedList<>();
    static Queue<Integer> leaveQueue = new LinkedList<>();

    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        Arrays.stream(enter).forEach(e -> enterQueue.offer(e));
        Arrays.stream(leave).forEach(e -> leaveQueue.offer(e));

        for (int i = 1; i <= enter.length; i++) people.put(i, 0);

        while (!enterQueue.isEmpty()) {
            int entered = enterQueue.poll();
            if (room.size() >= 1) {
                room.forEach(e -> people.put(e, people.get(e) + 1));
            }

            room.add(entered);
            people.put(entered, room.size());

            while(!leaveQueue.isEmpty() && room.contains(leaveQueue.peek())) {
                room.remove(leaveQueue.poll());
            }
        }
        for (int i = 0; i < enter.length; i++) answer[i] = people.get(i+1);
        return answer;
    }
}