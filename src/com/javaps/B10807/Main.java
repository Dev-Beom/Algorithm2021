package com.javaps.B10807;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            intList.add(scanner.nextInt());
        }
        int V = scanner.nextInt();
        long count =  intList.stream().filter(x -> x == V).count();
        System.out.println(count);
    }
}
