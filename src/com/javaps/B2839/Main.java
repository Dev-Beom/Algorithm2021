package com.javaps.B2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int b5 ,b3, r;

        b5 = N / 5;
        r  = N % 5; // 남는 설탕의 개수
        if (r == 0) {
            System.out.println(b5);
        } else if (r == 1 && b5 >= 1) {
            System.out.println(b5 - 1 + 2);
        } else if (r == 2 && b5 >= 2) {
            System.out.println(b5 - 2 + 4);
        } else if (r == 3) {
            System.out.println(b5 + 1);
        } else if (r == 4 && b5 >= 1) {
            System.out.println(b5 - 1 + 3);
        } else {
            System.out.println(-1);
        }
    }
}