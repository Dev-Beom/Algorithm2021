package com.javaps.P두개뽑아서더하기;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[hashSet.size()];

        ArrayList<Integer> list = new ArrayList(hashSet);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}