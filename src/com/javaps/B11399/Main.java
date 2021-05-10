package com.javaps.B11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        // INIT VARIABLE
        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> linkedList = new LinkedList<>();
        StringTokenizer tmp = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            linkedList.add(Integer.parseInt(tmp.nextToken()));
        }

        // SOLUTION
        linkedList.sort(Comparator.naturalOrder());


        /* ##### EXAMPLE
        * 1
        * 1+2
        * 1+2+3
        * 1+2+3+3
        * 1+2+3+3+4
        * */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += linkedList.get(j);
            }
        }

        System.out.println(sum);
    }
}
