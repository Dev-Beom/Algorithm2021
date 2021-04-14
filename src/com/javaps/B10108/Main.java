package com.javaps.B10108;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        IntStream charsStream = S.chars();
        int[] result = new int[26];
        charsStream.map(x -> {
            x = x - 97;
            return x;
        }).forEach(x -> result[x]++);
        Arrays.stream(result).forEach(x -> {
            System.out.print(x + " ");
        });
    }
}
