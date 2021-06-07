package com.javaps.B11650;

import java.io.*;
import java.util.*;

class Point {
    final int x;
    final int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        LinkedList<Point> points = new LinkedList<>();

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        points.sort(((o1, o2) -> {
            if (o1.x == o2.x)
                return o1.y - o2.y;
            else
                return o1.x - o2.x;
        }));
        points.forEach(point -> {
            System.out.println(point.x + " " + point.y);
        });
    }
}
