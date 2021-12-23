package com.javaps.B1972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("*")) break;
            display(line, isSurprising(line));
        }
    }

    private static boolean isSurprising(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            ArrayList<String> pairs = new ArrayList<>();
            for (int j = 0; j < str.length() - i - 1; j++) {
                String pair = String.valueOf(str.charAt(j)) + str.charAt(j + i + 1);
                if (pairs.contains(pair)) return false;
                pairs.add(pair);
            }
        }
        return true;
    }

    private static void display(String str, boolean state) {
        String stateStr = state ? " is surprising." : " is NOT surprising.";
        System.out.println(str + stateStr);
    }
}