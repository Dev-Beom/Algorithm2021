package com.javaps.B1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final static char EMPTY_BLOCK = 'X';
    final static char FILL_BLOCK = '.';
    final static String AAAA_BLOCK = "AAAA";
    final static String BB_BLOCK = "BB";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            char currCharacter = line.charAt(i);
            if (currCharacter == EMPTY_BLOCK && i != line.length() - 1) {
                cnt++;
            } else {
                if (currCharacter == EMPTY_BLOCK) {
                    cnt++;
                    if (cnt % 2 == 0) {
                        for (int j = 0; j < cnt / 4; j++) {
                            sb.append(AAAA_BLOCK);
                        }
                        for (int j = 0; j < (cnt % 4) / 2; j++) {
                            sb.append(BB_BLOCK);
                        }
                        cnt = 0;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                } else if (currCharacter == FILL_BLOCK) {
                    if (cnt % 2 == 0) {
                        for (int j = 0; j < cnt / 4; j++) {
                            sb.append(AAAA_BLOCK);
                        }
                        for (int j = 0; j < (cnt % 4) / 2; j++) {
                            sb.append(BB_BLOCK);
                        }
                        cnt = 0;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    sb.append(FILL_BLOCK);
                }
            }
        }
        System.out.println(sb);
    }
}
