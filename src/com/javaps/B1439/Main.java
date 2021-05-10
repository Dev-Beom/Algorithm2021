package com.javaps.B1439;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S);

        char now = '0';

        int O = 0;
        int X = 0;

        for (int i = 0; i < S.length(); i++) {
            char thisValue = S.charAt(i);

            // First Value Setting
            if (i == 0) {
                now = thisValue;
                if (thisValue == '0') O++;
                else X++;
            } else {
                if (now != thisValue) {
                    if (thisValue == '0') O++;
                    else X++;
                    now = thisValue;
                }
            }
        }

        System.out.println(Math.min(O, X));
    }
}
