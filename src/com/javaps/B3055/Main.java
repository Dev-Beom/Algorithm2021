package com.javaps.B3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] map;
    static boolean[][] visited;	// T : 이동 불가능, F : 이동 가능.
    static Queue<Point> waters;

    static int[] moveX = { 0, 1, 0, -1 };
    static int[] moveY = { -1, 0, 1, 0 };
    static int x, y;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y][x];
        visited = new boolean[y][x];
        waters = new LinkedList<Point>();

        Point startPoint = null;
        Point endPoint = null;

        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            map[i] = line.toCharArray();
            for(int j = 0; j < x; j++) {
                switch(map[i][j]) {
                    case 'D':
                        endPoint = new Point(j, i);
                        visited[i][j] = true;
                        break;
                    case 'S':
                        startPoint = new Point(j, i);
                        break;
                    case '*':
                        waters.add(new Point(j, i));
                        visited[i][j] = true;
                        break;
                    case 'X':
                        visited[i][j] = true;
                        break;
                }
            }
        }

        int result = escape(startPoint, endPoint);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    // 고슴도치 탈출 함수
    static int escape(Point start, Point end) {
        int time = 0;
        Queue<Point> goSumDoChi = new LinkedList<Point>();
        goSumDoChi.offer(start);

        while(true) {
            if(goSumDoChi.isEmpty()) {
                return -1;
            }
            // 물 셋팅
            setWaterFlow();

            // 고슴도치 이동시키기
            Queue<Point> nextGoSumDoChi = new LinkedList<Point>();
            while(!goSumDoChi.isEmpty()) {
                Point goSum = goSumDoChi.poll();
                for(int i = 0; i < moveX.length; i++) {
                    int nextX = goSum.x + moveX[i];
                    int nextY = goSum.y + moveY[i];
                    // 고슴도치가 이동해서 동굴에 도착할 수 있다면
                    if(nextX == end.x && nextY == end.y) {
                        return time + 1;
                    }

                    if(validPoint(nextX, nextY)) {
                        visited[nextY][nextX] = true;
                        nextGoSumDoChi.add(new Point(nextX, nextY));
                    }
                }
            }
            goSumDoChi = nextGoSumDoChi;
            time++;
        }
    }

    // 물 상하좌우로 흐르는 것을 visited boolean 배열에 나타내는 함수
    static void setWaterFlow() {
        Queue<Point> nextWaters = new LinkedList<Point>();

        while(!waters.isEmpty()) {
            Point water = waters.poll();
            for(int i = 0; i < moveX.length; i++) {
                int nextX = water.x + moveX[i];
                int nextY = water.y + moveY[i];
                if(validPoint(nextX, nextY)) {
                    visited[nextY][nextX] = true;
                    nextWaters.add(new Point(nextX, nextY));
                }
            }
        }
        waters = nextWaters;
    }

    // 해당 지점에 이동할 수 있는지(물이든 고슴도치이든) 체크하는 함수
    static boolean validPoint(int pointX, int pointY) {
        if(pointX < 0 || pointX >= x) {
            return false;
        }
        if(pointY < 0 || pointY >= y) {
            return false;
        }
        if(visited[pointY][pointX]) {
            return false;
        }
        return true;
    }
}
