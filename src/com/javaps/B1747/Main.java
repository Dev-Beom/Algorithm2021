package com.javaps.B1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(2);
            return;
        }

        while (true) {
            if (isPrimeNumber(N) && isPalindrome(N)){
                System.out.println(N);
                break;
            }
            N++;
        }
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(int number) {
        StringBuilder sb = new StringBuilder().append(number).reverse();
        return String.valueOf(number).equals(sb.toString());
    }
}
