package com.javaps.B1026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        int sum = 0;

        // INPUT A
        String[] tmp = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(tmp[i]));
        }

        // INPUT B
        tmp = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(tmp[i]));
        }

        A.sort(Comparator.reverseOrder());
        B.sort(Comparator.naturalOrder());

        for(int i = 0; i < N; i++) {
            sum += A.get(i) * B.get(i);
        }

        System.out.println(sum);
    }
}
