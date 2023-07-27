package com.javaps.B4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final String END_LINE = "end";
    static final char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};
    static final char[] CONSONANTS = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = br.readLine();
            if (command.equals(END_LINE)) {
                return;
            }
            display(command, isValid(command));
        }
    }

    private static void display(String command, boolean isValid) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(command).append(">").append(" is ");
        if (!isValid) sb.append("not ");
        sb.append("acceptable.");
        System.out.println(sb);
    }


    private static boolean isValid(String password) {
        return isContainsVowel(password)
                && isNotRepeatBySet(password, VOWELS)
                && isNotRepeatBySet(password, CONSONANTS)
                && isNotRepeat(password);
    }

    private static boolean isContainsVowel(String password) {
        for (char vowel : VOWELS) {
            if (password.contains(String.valueOf(vowel))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotRepeat(String password) {
        if (password.length() == 1) return true;
        int repeatCount = 2;
        for (int index = 0; index < password.length() - repeatCount + 1; index++) {
            String validTarget = password.substring(index, index + repeatCount);
            char first = validTarget.charAt(0);
            char second = validTarget.charAt(1);
            if (validTarget.equals("ee") || validTarget.equals("oo")) {
                return true;
            }
            if (first == second) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotRepeatBySet(String password, char[] set) {
        int repeatCount = 3;
        for (int index = 0; index < password.length() - repeatCount + 1; index++) {
            String validTarget = password.substring(index, index + repeatCount);
            if (isAllIncludeSet(validTarget, set)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllIncludeSet(String string, char[] set) {
        int count = 0;
        for (char character : string.toCharArray()) {
            if (String.valueOf(set).contains(String.valueOf(character))) count++;
        }
        return count == string.length();
    }
}
