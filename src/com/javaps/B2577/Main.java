package com.javaps.B2577;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int ABC = A * B * C;
        String string = String.valueOf(ABC);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            System.out.println(string.chars().filter(x -> x == (char) (finalI + '0')).count());
        }
    }
}