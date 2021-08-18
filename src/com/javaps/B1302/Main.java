package com.javaps.B1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        for (String a : map.keySet()) {
            max = Math.max(max, map.get(a));
        }

        ArrayList<String> arrayList = new ArrayList<String>(map.keySet());
        Collections.sort(arrayList);
        for (String element : arrayList) {
            if (map.get(element) == max) {
                System.out.println(element);
                break;
            }
        }
    }
}
