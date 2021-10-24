package com.javaps.CD.NHNOR3;

public class main {
    static int cnt = 0;
    static int[] children = {1, 2, 3, 4, 5, 6, 7, 8};
    static int[][] cnf;

    private static void solution(int numOfConflict, int[][] conflicts) {
        cnf = conflicts;
        permutation(children, 0, 8, 8);
        System.out.println(cnt);
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < cnf.length; i++) {
                int a = getIdx(arr, cnf[i][0]);
                int b = getIdx(arr, cnf[i][1]);

                if (Math.abs(a - b) == 1) return;
            }
            cnt++;
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static int getIdx(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    static void swap(int[] arr, int depth, int i) {
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }
}
