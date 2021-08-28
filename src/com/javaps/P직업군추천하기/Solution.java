package com.javaps.P직업군추천하기;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


class Occupation {
    String name;
    String[] langs;
    int score;

    Occupation(String name, String[] langs) {
        this.name = name;
        this.langs = langs;
        this.score = 0;
    }

    public int getScore(String lang) {
        for (int i = 0; i < langs.length; i++) {
            if (lang.equals(langs[i])) {
                return (5 - i);
            }
        }
        return 0;
    }
}

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        ArrayList<Occupation> occList = new ArrayList<>();
        for (String e : table) {
            String[] arr = e.split(" ");
            String name = arr[0];
            String[] langs = Arrays.copyOfRange(arr, 1, arr.length);
            occList.add(new Occupation(name, langs));
        }

        for (Occupation occ : occList) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < languages.length; i++) {
                occ.score += occ.getScore(languages[i]) * preference[i];
            }
        }

        Collections.sort(occList, (o1, o2) -> {
            if (o1.score == o2.score) {
                return o1.name.compareTo(o2.name);
            }
            return o2.score - o1.score;
        });

        return occList.get(0).name;
    }
}