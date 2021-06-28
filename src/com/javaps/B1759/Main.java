package com.javaps.B1759;

/*
 * 문제 유형 : 조합, 백트래킹
 * 문제 난이도 : 골드 5
 * 풀이 시간 : 13분 41초
 * 제출 실패 횟수 : 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");
        Arrays.sort(arr);

        combination(0, "");
    }

    public static void combination(int index, String str) {
        if (str.length() == L) {    // 종료 조건
            if (isPossible(str)) {
                System.out.println(str);
                return;
            }
        }
        if (index >= C) return;
        combination(index + 1, str + arr[index]);   // 자기자신과 다음 문자까지 같이
        combination(index + 1, str);                    // 자기자신만
    }

    public static boolean isPossible(String str) {
        int vowel = 0;      // 모음
        int consonant = 0;  // 자음
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) vowel++;
            else consonant++;
        }
        return vowel >= 1 && consonant >= 2;    // 문제에서 제시한 조건
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
