package com.javaps.B1990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        B = Math.min(B, 10000000);
        arr = new boolean[B + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= B; i++) {
            for (int j = i * i; j <= B; j+= i) {
                arr[j] = false;
            }
        }
        for (int i = A; i <= B; i++) {
            if (arr[i] && isPalindrome(i)) {
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }

    public static boolean isPalindrome(int number) {
        String numberToString = String.valueOf(number);
        StringBuilder sb = new StringBuilder(numberToString);
        return numberToString.equals(sb.reverse().toString());
    }
}
