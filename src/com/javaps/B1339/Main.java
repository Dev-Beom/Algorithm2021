package com.javaps.B1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder(line);
            strings[i] = sb.reverse().toString();
        }

        Arrays.sort(strings, ((o1, o2) -> o2.length() - o1.length()));
        int maxLengthString = strings[0].length() - 1;

        for (int i = maxLengthString; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i >= strings[j].length()) break;

                char ch = strings[j].charAt(i);
                int pow = (int) Math.pow(10, i);
                if (!map.containsKey(ch)) {
                    map.put(ch, pow);
                } else {
                    map.put(ch, map.get(ch) + pow);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (char ch : map.keySet()) {
            list.add(map.get(ch));
        }
        list.sort(((o1, o2) -> o2 - o1));
        int num = 9;
        int ans = 0;
        for (Integer integer : list) {
            ans += integer * num--;
        }
        System.out.println(ans);
    }
}
