package com.javaps.B3018;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Node {
    String name;
    String value;

    Node(String name, String value) {
        this.name = name;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Node> res = new ArrayList<>();
        int allCnt = 0;
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if (name.equals("")) break;
            else {
                map.put(name, map.getOrDefault(name, 0) + 1);
                allCnt++;
            }
        }
        for (String key : map.keySet()) {
            int value = map.get(key);
            double percentage = (double) value / (double) allCnt * 100;
            res.add(new Node(key, String.format("%.4f", percentage)));
        }
        res.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        res.forEach(x -> {
            System.out.println(x.name + " " + x.value);
        });
    }
}
