package com.javaps.B10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Node {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {

    static ArrayList<Node> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            int moveCount = 0;
            for (int j = 0; j < 20; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (arr.isEmpty()) {
                    arr.add(value);
                    continue;
                }
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) > value) {
                        arr.add(i, value);
                        moveCount += arr.size() - 1 - i;
                    } else {
                        arr.add(value);
                    }
                }
            }
            result.add(new Node(index, moveCount));
        }
        result.forEach(node -> {
            System.out.println(node.index + " " + node.value);
        });
    }
}
