package com.javaps.B2644;

import java.util.*;
import java.io.*;

class Person {
    int index, value;

    Person(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    static int N;
    static int people1;
    static int people2;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 사람의 수
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        people1 = Integer.parseInt(st.nextToken());
        people2 = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }
        if (people1 == people2) System.out.println(0);
        else System.out.println(bfs(people1));
    }

    static int bfs(int x) {
        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            Person person = queue.poll();
            int now = person.index;
            if (now == people2) return person.value;

            for (int i = 1; i <= N; i++) {
                if (arr[i][now] == 1 && !visited[i]) {
                    queue.offer(new Person(i, person.value + 1));
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}
