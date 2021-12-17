package com.javaps.B17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] line = br.readLine().toCharArray();
            if (isPalindrome(line, 0, line.length - 1)) System.out.println(0);
            else if (isSimilarityPalindrome(line, 0, line.length - 1)) System.out.println(1);
            else System.out.println(2);
        }
    }

    private static boolean isPalindrome(char[] word, int left, int right) {
        while (left <= right) {
            if (word[left] != word[right]) return false;
            left += 1;
            right -= 1;
        }
        return true;
    }

    private static boolean isSimilarityPalindrome(char[] word, int left, int right) {
        while (left <= right) {
            if (word[left] != word[right]) {
                boolean leftDelete = isPalindrome(word, left + 1, right);
                boolean rightDelete = isPalindrome(word, left, right - 1);
                return leftDelete || rightDelete;
            }
            left += 1;
            right -= 1;
        }
        return false;
    }
}
