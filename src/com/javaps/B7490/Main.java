package com.javaps.B7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            DFS(N, 1, 1, 1, 0, "1");
            System.out.println();
        }
    }

    static void DFS(int max, int now, int num, int sign, int sum, String str) {
        if (max == now) {
            sum = sum + (num * sign);
            if (sum == 0) {
                System.out.println(str);
            }
            return;
        }
        DFS(max, now + 1, num * 10 + (now + 1), sign, sum, str + " " + (now + 1));
        DFS(max, now + 1, now + 1, 1, sum + (num * sign), str + "+" + (now + 1));
        DFS(max, now + 1, now + 1, -1, sum + (num * sign), str + "-" + (now + 1));
    }
}
