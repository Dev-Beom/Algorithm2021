package com.javaps.B1475;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Integer> hasNumber = new ArrayList<>();
    private static final List<Integer> intList = new ArrayList<>();

    private static void getPackage() {
        hasNumber.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 6, 7, 8));
    }

    private static boolean findAndDelete(Integer number) {
        for (int i = 0; i < hasNumber.size(); i++) {
            if (hasNumber.get(i).equals(number)) {
                hasNumber.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean checkOut(Integer number) {
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i).equals(number)) {
                intList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        // Room Number
        String N = scanner.nextLine();


        // Room Number List
        N.chars().forEach(x -> {
            if (x == '9') {
                // if number is '9' trans to 6
                intList.add(6);
            } else {
                intList.add((int) x - 48);
            }
        });
        result++;
        getPackage();
        while (intList.size() > 0) {
            for (int i = 0; i < intList.size(); i++) {
                Integer data = intList.get(i);
                if (findAndDelete(data) && checkOut(data)) {

                } else {
                    result++;
                    getPackage();
                }
            }
        }
        System.out.println(result);
    }
}
