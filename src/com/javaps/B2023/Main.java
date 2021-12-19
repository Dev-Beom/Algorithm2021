package com.javaps.B2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS("", 0);
        System.out.println(sb.toString());
    }

    private static void DFS(String number, int depth) {
        int[] numberSet = {1, 2, 3, 5, 7, 9};
        if (depth == N) {
            sb.append(number).append('\n');
            return;
        }
        for (int element : numberSet) {
            if (isPrime(Integer.parseInt(number + element))) {
                DFS(number + element, depth + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
