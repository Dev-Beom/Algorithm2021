package com.javaps.P다트게임;

import java.util.*;

class Solution {
    static int number;
    static ArrayList<Integer> numbers = new ArrayList<>();
    public int solution(String dartResult) {
        int answer = 0;
        boolean isTen = false;
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            // 숫자 입력 경우
            // 10이 입력된 경우
            if (isTen == true) {
                isTen = false;
                continue;
            }
            if (isNumber(ch) && isNumber(dartResult.charAt(i + 1))) {
                isTen = true;
                number = getBonus((getNumber(ch) * 10) + getNumber(dartResult.charAt(i + 1)),
                        dartResult.charAt(i + 2));
                if (i < dartResult.length() - 3 && isOption(dartResult.charAt(i + 3))) {
                    if (dartResult.charAt(i + 3) == '*') {
                        if (i == 0) {
                            number = number * 2;
                        } else {
                            number = number * 2 + numbers.get(numbers.size() - 1);
                        }
                    } else if (dartResult.charAt(i + 3) == '#') {
                        number = number * -1;
                    }
                }
                numbers.add(number);
                continue;
            }
            if (isNumber(ch)) {
                // 일반 숫자인 경우
                number = getBonus(getNumber(ch), dartResult.charAt(i + 1));
                if (i < dartResult.length() - 2 && isOption(dartResult.charAt(i + 2))) {
                    if (dartResult.charAt(i + 2) == '*') {
                        if (i == 0) {
                            number = number * 2;
                        } else {
                            number = number * 2 + numbers.get(numbers.size() - 1);
                        }
                    } else if (dartResult.charAt(i + 2) == '#') {
                        number = number * -1;
                    }
                }
                numbers.add(number);
            }
        }

        for (Integer e : numbers) {
            answer += e;
        }
        return answer;
    }

    public static boolean isOption(char value) {
        return value == '*' || value == '#';
    }

    public static int getBonus(int value, char bonus) {
        switch (bonus) {
            case 'S':
                return value;
            case 'D':
                return value * value;
            case 'T':
                return value * value * value;
        }
        return 0;
    }

    public static boolean isNumber(char value) {
        if (48 <= value && value <= 57) {
            return true;
        }
        return false;
    }

    public static int getNumber(char value) {
        return value - '0';
    }
}