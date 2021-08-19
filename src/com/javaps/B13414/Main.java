package com.javaps.B13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        for (int i = 0; i < L; i++) {
            String key = br.readLine();
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, 1);
            } else {
                map.put(key, 1);
            }
        }
        int cnt = 0;
        for (String key : map.keySet()) {
            if (cnt == K) break;
            System.out.println(key);
            cnt++;
        }
    }
}
