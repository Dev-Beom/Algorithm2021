package com.javaps.B8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Country implements Comparable<Country> {
    int id;
    int gold;
    int silver;
    int bronze;

    public Country(int id, int gold, int silver, int bronze) {
        super();
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country o) {
        if (this.gold == o.gold) {
            if (this.silver == o.silver) {
                return -(this.bronze - o.bronze);
            } else return -(this.silver - o.silver);
        } else return -(this.gold - o.gold);
    }
}

public class Main {
    static int N;   // 국가의 수
    static int K;   // 등수를 알고 싶은 국가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Country> countryPriorityQueue = new PriorityQueue<Country>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int myScore = 0;
        int rank = 1;
        int[] arr = new int[N];

        // 참여한 국가의 정보를 입력받음.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countryPriorityQueue.offer(new Country(id, gold, silver, bronze));
        }
        Country tmp = countryPriorityQueue.poll();
        if (tmp.id == K) {
            System.out.println(rank);
            return;
        }
        int same = 0;
        while (!countryPriorityQueue.isEmpty()) {
            Country m = countryPriorityQueue.poll();
            if (!(tmp.gold == m.gold && tmp.silver == m.silver && tmp.bronze == m.bronze)) {
                tmp = m;
                rank++;
                if (same > 0) {
                    rank += same;
                    same = 0;
                }
            } else {
                same++;
            }
            if (m.id == K) {
                System.out.println(rank);
            }
        }
    }
}
