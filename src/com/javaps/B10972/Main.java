package com.javaps.B10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        if (nextPermutation(arr)) {
            for (Integer e : arr)
                System.out.print(e + " ");
        } else {
            System.out.println("-1");
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean nextPermutation(int[] arr) {
        //1. a[i-1] < a[i]를 만족하는 첫 번째 수 찾기
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i -= 1;
        }

        // 마지막 순열인 경우
        if (i <= 0) {
            return false;
        }
        //2. a[i-1] < a[j]를 만족하는 첫 번째 수 찾기
        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j -= 1;
        }

        //3. a[i-1]과 a[j] swap
        swap(arr, i - 1, j);

        //4 i부터 a.length-1까지 순열 뒤집기
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }
}
