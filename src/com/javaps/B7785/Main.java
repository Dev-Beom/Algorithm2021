package com.javaps.B7785;

/*
* 문제 유형 : 해시셋
* 문제 난이도 : 실버 5
* 풀이 시간 : 7분 56초
* 제출 실패 횟수 : 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    static HashSet<String> log = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[1].equals("enter")) {
                log.add(command[0]);
            } else {
                log.remove(command[0]);
            }
        }
        log.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
