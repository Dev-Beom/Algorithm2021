package com.javaps.B2947;

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i+1);
                }
                if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5){
                    break;
                }
            }
            if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5){
                break;
            }
        }
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
