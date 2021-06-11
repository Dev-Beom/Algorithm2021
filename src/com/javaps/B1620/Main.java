package com.javaps.B1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도감에 수록되어있는 포켓몬의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashMapNum = new HashMap<>();
        HashMap<String, Integer> hashMapStr = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            String inputStr = br.readLine();
            hashMapNum.put(n, inputStr);
            hashMapStr.put(inputStr, n);
        }
        for (int m = 0; m < M; m++) {
            String searchStr = br.readLine();
            if (Character.isDigit(searchStr.charAt(0))) {
                int id = Integer.parseInt(searchStr);
                System.out.println(hashMapNum.get(id));
            } else {
                String id = searchStr;
                System.out.println(hashMapStr.get(id));
            }
        }
    }
}
