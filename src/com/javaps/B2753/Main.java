package com.javaps.B2753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (isMultiplicationOf4(input)) {
            if (!isMultiplicationOf100(input) || isMultiplicationOf400(input)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

    private static boolean isMultiplicationOf4(int number) {
        return number % 4 == 0;
    }

    private static boolean isMultiplicationOf100(int number) {
        return number % 100 == 0;
    }

    private static boolean isMultiplicationOf400(int number) {
        return number % 400 == 0;
    }
}
