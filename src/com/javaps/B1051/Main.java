package com.javaps.B1051;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                board[n][m] = str.charAt(m) - '0';
            }
        }

        int min = Math.min(N, M);
        int maxSize = 0;
        int cnt = 0;
        while (cnt <= min) {
            cnt++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + cnt < N && j + cnt < M) {
                        if (board[i][j] == board[i][j + cnt] && board[i][j] == board[i + cnt][j + cnt] && board[i][j] == board[i + cnt][j]) {
                            maxSize = Math.max(maxSize, cnt);
                        }
                    }
                }
            }
        }
        System.out.println((maxSize + 1) * (maxSize + 1));
    }
}
