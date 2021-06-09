package com.javaps.B2799;

import java.io.*;
import java.util.*;

public class Main {

    static char[][] window;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        window = new char[5 * M + 1][5 * N + 1];
        result = new int[5];


        for (int i = 0; i < window.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < window[0].length; j++) {
                window[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < window.length; i++) {
            for (int j = 0; j < window[0].length; j++) {
                if (window[i][j] == '*' || window[i][j] == '.') {
                    checkTypeAndFill(i, j);
                }
            }
        }

//        for (int i = 0; i < window.length; i++) {
//            for (int j = 0; j < window[0].length; j++) {
//                System.out.print(window[i][j]);
//            }
//            System.out.println();
//        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static void checkTypeAndFill(int a, int b) {
        int star = 0;
        int dot = 0;
        for (int i = 0; i < 4; i++) {
            if (window[a + i][b] == '*') {
                star++;
            } else if (window[a + i][b] == '.') {
                dot++;
            }
        }
        if (star == 0 && dot == 4) {
            result[0]++;
        } else if (star == 1 && dot == 3) {
            result[1]++;
        } else if (star == 2 && dot == 2) {
            result[2]++;
        } else if (star == 3 && dot == 1) {
            result[3]++;
        } else if (star == 4 && dot == 0) {
            result[4]++;
        }
        for (int i = a; i < a + 4; i++) {
            for (int j = b; j < b + 4; j++) {
                window[i][j] = '#';
            }
        }
    }
}
