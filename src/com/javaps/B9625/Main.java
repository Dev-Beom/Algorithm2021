package com.javaps.B9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a = 1;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        if (K == 1) {
            a = 0; b = 1;
        } else {
            for (int i = 1; i <= K; i++) {
                logic();
            }
        }
        System.out.println(a + " " + b);
    }

    static void logic() {
        int tmp = b;
        b = a + b;
        a = tmp;
    }
}
