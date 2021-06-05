package com.javaps.B15686;

import java.io.*;
import java.util.*;

class Chicken {
    int row;
    int column;
    int value = 0;

    Chicken(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void addValue(int value) {
        this.value += value;
    }
}

class Home {
    int row;
    int column;
    int value = Integer.MAX_VALUE;

    Home(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        LinkedList<Chicken> chickens = new LinkedList<>();
        LinkedList<Home> homes = new LinkedList<>();

        // INPUT
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Home(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }

        // 임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
        // 치킨집 데이터 (치킨집 <-> 집들의 거리 값을 보유)
        for (Chicken chicken : chickens) {
            for (Home home : homes) {
                int rows = chicken.row - home.row;
                int columns = chicken.column - home.column;
                rows = rows < 0 ? rows * -1 : rows;
                columns = columns < 0 ? columns * -1 : columns;
                chicken.addValue(rows + columns);
            }
        }

        // 치킨집 폐업시키기
        if (M < chickens.size()) {
            chickens.sort(Comparator.comparingInt(o -> o.value));
            if (chickens.size() > M) {
                chickens.subList(M, chickens.size()).clear();
            }
        }

        // 집 데이터 (집 <-> 치킨집들의 거리 값을 보유)
        for (Home home : homes) {
            for (Chicken chicken : chickens) {
                int rows = chicken.row - home.row;
                int columns = chicken.column - home.column;
                rows = rows < 0 ? rows * -1 : rows;
                columns = columns < 0 ? columns * -1 : columns;
                if (home.getValue() > rows + columns) {
                    home.setValue(rows + columns);
                }
            }
        }

        int result = 0;
        for (Home home : homes) {
            result += home.getValue();
        }
        System.out.println(result);
    }
}
