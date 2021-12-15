package com.javaps.B12757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final static int COMMAND_ADD = 1, COMMAND_UPDATE = 2, COMMAND_PRINT = 3;
    static int N, M, K;
    static TreeMap<Integer, Integer> table = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tableInit();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            table.put(key, value);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            int value = command == COMMAND_PRINT ? 0 : Integer.parseInt(st.nextToken());
            switch (command) {
                case COMMAND_ADD:
                    addValue(key, value);
                    break;
                case COMMAND_UPDATE:
                    updateValue(key, value);
                    break;
                case COMMAND_PRINT:
                    printValue(key);
                    break;
                default:
                    break;
            }
        }
    }

    private static void tableInit() {
        table.put(-2000000000, -1);
        table.put(2000000000, -1);
    }

    private static void addValue(int key, int value) {
        table.put(key, value);
    }

    private static void updateValue(int key, int value) {
        int rightKey = table.ceilingKey(key);
        int leftKey = table.floorKey(key);

        if (table.get(rightKey) == table.get(leftKey)) {
            table.put(key, value);
        } else if (rightKey - key < key - leftKey && K >= rightKey - key) {
            table.put(rightKey, value);
        } else if (rightKey - key > key - leftKey && K >= key - leftKey) {
            table.put(leftKey, value);
        }
    }

    private static void printValue(int key) {
        int rightKey = table.ceilingKey(key);
        int leftKey = table.floorKey(key);

        if (table.get(rightKey) == table.get(leftKey)) {
            System.out.println(table.get(key));
        } else if (rightKey - key == key - leftKey && K >= rightKey - key) {
            System.out.println("?");
        } else if (rightKey - key < key - leftKey && K >= rightKey - key) {
            System.out.println(table.get(rightKey));
        } else if (rightKey - key > key - leftKey && K >= key - leftKey) {
            System.out.println(table.get(leftKey));
        } else {
            System.out.println("-1");
        }
    }
}
