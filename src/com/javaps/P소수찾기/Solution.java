package com.javaps.P소수찾기;

import java.util.HashSet;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] sosu = new boolean[n + 1];

        for (int i = 2; i <= n; i++) sosu[i] = true;
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) if (sosu[i]) for (int j = i; i * j <= n; j++) sosu[i * j] = false;
        for (int i = 2; i <= n; i++) if (sosu[i]) answer++;
        return answer;
    }
}

class Solution2 {
    static HashSet<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);
        return primes.size();
    }

    private static void permutation(String s1, String s2) {
        if (!s1.equals("") && isPrimeNumber(Integer.parseInt(s1))) {
            primes.add(Integer.valueOf(s1));
        }
        for (int i = 0; i < s2.length(); i++) {
            permutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}