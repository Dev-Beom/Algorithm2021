package com.javaps.B4134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            BigInteger N = new BigInteger(br.readLine());
            if (N.isProbablePrime(100)) {
                System.out.println(N);
            } else {
                System.out.println(N.nextProbablePrime());
            }
        }
    }
}
