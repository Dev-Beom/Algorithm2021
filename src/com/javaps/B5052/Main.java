package com.javaps.B5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_number = new String[N];

            for (int i = 0; i < N; i++) {
                phone_number[i] = br.readLine();
            }
            Arrays.sort(phone_number);
            if (isConsistent(N, phone_number)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isConsistent(int N, String[] phone_number) {
        for (int i = 0; i < N - 1; i++) {
            if (phone_number[i + 1].startsWith(phone_number[i])) {
                return false;
            }
        }
        return true;
    }
}
