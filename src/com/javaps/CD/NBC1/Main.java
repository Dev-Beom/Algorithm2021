package com.javaps.CD.NBC1;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    static String[] solution(String[] arr) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for (String str : arr) {
            String filename = getOriginalFilename(str);
            map.put(filename, map.getOrDefault(filename, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
                list.add(String.valueOf(entry.getValue()));
            }
        }
        return list.toArray(new String[0]);
    }

    static String getOriginalFilename(String str) {
        StringBuilder sb = new StringBuilder();
        while (str.contains("/")) {
            int idx = str.indexOf("/");
            str = str.substring(idx + 1);
        }
        sb.append(str.charAt(0)).append(".").append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"/d/d/f/x.z", "/a/x_v2.y", "a/z.z", "/x/g/s/x_v5.y", "d/d/d/a/x.z", "x_v2.y", "/d/d/a/k_v1.x", "t.x", "x/x/x/x.x", "t.x", "y_v19.x", "x_v3.y"};

        for (String item : solution(str)) {
            System.out.print(item + " ");
        }
    }
}
