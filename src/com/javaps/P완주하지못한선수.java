package com.javaps;

import java.io.*;
import java.util.*;

public class P완주하지못한선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap<String, Integer> map = new HashMap<>();

            int cnt = 0;
            for (String e : participant) {
                if (map.get(e) == null) {
                    map.put(e, 1);
                } else {
                    cnt = map.get(e) + 1;
                    map.put(e, cnt);
                }
            }

            for (String e : completion) {
                cnt = map.get(e) - 1;
                map.put(e, cnt);
            }

            for (String key : map.keySet()) {
                if (map.get(key) == 1) {
                    answer = key;
                }
            }
            return answer;
        }
    }
}
