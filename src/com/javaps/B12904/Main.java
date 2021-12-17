package com.javaps.B12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(), T = br.readLine();

        while (S.length() != T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = logicA(T);
            } else {
                T = logicB(T);
            }
        }
        System.out.println(S.equals(T) ? 1 : 0);
    }

    static private String logicA(String str) {
        return str.substring(0, str.length() - 1);
    }

    static private String logicB(String str) {
        String tmp = str.substring(0, str.length() - 1);
        return new StringBuilder(tmp).reverse().toString();
    }
}
