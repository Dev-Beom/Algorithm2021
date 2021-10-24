package com.javaps.CD.NHNOR2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class main {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int sum = 0;

    private static void solution(int numOfRegion, int numOfAttackableFrequency, int[][] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                int val = frequencies[i][j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o2, o1) -> map.get(o1.getKey()) - map.get(o2.getKey())));

        for (int i = 0; i < numOfAttackableFrequency; i++) sum += entryList.get(i).getValue();
        System.out.println(sum);
    }
}
