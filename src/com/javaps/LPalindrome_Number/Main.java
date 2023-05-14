package com.javaps.LPalindrome_Number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        String before = stringBuilder.toString();
        String after = stringBuilder.reverse().toString();
        return before.equals(after);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol .isPalindrome(10));
    }
}
