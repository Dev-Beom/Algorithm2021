package com.javaps.CD.NBC2;

import java.io.IOException;
import java.util.*;

public class Main {

    static ArrayList<Character> memory = new ArrayList<>();
    static HashMap<String, Integer> type = new HashMap<>();

    static String solution(String[] arr) {
        type.put("BOOL", 1);
        type.put("SHORT", 2);
        type.put("FLOAT", 4);
        type.put("INT", 8);
        type.put("LONG", 16);

        for (String str : arr)
            if (!setMemory(type.get(str)))
                return "HALT";

        if (memory.size() % 8 != 0) trimming();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < memory.size(); i++) {
            if (i != 0 && i % 8 == 0) sb.append(',');
            sb.append(memory.get(i));
        }
        return sb.toString();
    }

    public static boolean setMemory(int cnt) {
        int tmp = cnt;
        if (cnt == 16) cnt = 8;
        while (memory.size() % cnt != 0) {
            memory.add('.');
            if (memory.size() > 128) return false;
        }
        cnt = tmp;
        for (int i = 0; i < cnt; i++) {
            memory.add('#');
            if (memory.size() > 128) return false;
        }
        return true;
    }

    public static void trimming() {
        while (memory.size() % 8 != 0) memory.add('.');
    }


    public static void main(String[] args) throws IOException {
        String[] str1 = {"INT", "INT", "BOOL", "SHORT", "LONG"};                                                    // -> ########,########,#.##....,########,########
        String[] str2 = {"INT", "SHORT", "FLOAT", "INT", "BOOL"};                                                   // -> ########,##..####,########,#.......
        String[] str3 = {"FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"};                                          // -> ########,#.......,########
        String[] str4 = {"BOOL", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"}; // -> HALT

//        System.out.println(solution(str1));
//        System.out.println(solution(str2));
//        System.out.println(solution(str3));
        System.out.println(solution(str4));
    }
}
