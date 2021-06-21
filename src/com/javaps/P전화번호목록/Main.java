package com.javaps.P전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String item : phone_book) hashMap.put(item, 0);
        for (String key : hashMap.keySet()) {
            for (int i = 1; i < key.length(); i++) {
                if (hashMap.containsKey(key.substring(0, i))) return false;
            }
        }
        return true;
    }
}
