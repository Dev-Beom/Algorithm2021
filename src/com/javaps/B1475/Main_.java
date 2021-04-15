package com.javaps.B1475;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_ {

    private static final List<Integer> numberPackage = new ArrayList<>();

    private static void setNumberPackage() {
        numberPackage.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private static void resetNumberPackage() {
        numberPackage.clear();
        numberPackage.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private static void popNumberAs() {
        System.out.println("delete" + (Integer) 1);
        numberPackage.forEach(System.out::println);
        numberPackage.removeIf(x -> x.equals(1));
        numberPackage.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Room Number
        String N = scanner.nextLine();

        // Room Number List
        List<Integer> intList = new ArrayList<>();
        N.chars().forEach(x -> intList.add((int) x - 48));
        intList.forEach(System.out::println);

        popNumberAs();
    }
}
