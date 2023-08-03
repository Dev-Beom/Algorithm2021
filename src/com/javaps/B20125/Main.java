package com.javaps.B20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Position {
    int i, j;

    Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void set(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return (i + 1) + " " + (j + 1);
    }
}

public class Main {

    private static final char BODY = '*';
    private static final char EMPTY = '_';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Position heart = findHeart(map);
        Position waist = findWaist(map);
        int leftHandCount = findLeftHandCount(heart, map);
        int rightHandCount = findRightHandCount(heart, map);
        int bodyCount = findBodyCount(heart, map);
        int leftLegCount = findLeftLegCount(waist, map);
        int rightLegCount = findRightLegCount(waist, map);
        System.out.println(heart);
        System.out.println(leftHandCount + " " + rightHandCount + " " + bodyCount + " " + leftLegCount + " " + rightLegCount);
    }

    static Position findHeart(char[][] map) throws RuntimeException {
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map.length - 1; j++) {
                if (isHeart(i, j, map)) {
                    return new Position(i, j);
                }
            }
        }
        throw new RuntimeException("not found heart");
    }

    static Position findWaist(char[][] map) throws RuntimeException {
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map.length - 1; j++) {
                if (isWaist(i, j, map)) {
                    return new Position(i, j);
                }
            }
        }
        throw new RuntimeException("not found waist");
    }

    static int findLeftHandCount(Position heart, char[][] map) {
        int count = 0;
        for (int j = heart.j - 1; j >= 0; j--) {
            if (map[heart.i][j] == EMPTY) return count;
            count++;
        }
        return count;
    }

    static int findRightHandCount(Position heart, char[][] map) {
        int count = 0;
        for (int j = heart.j + 1; j < map.length; j++) {
            if (map[heart.i][j] == EMPTY) return count;
            count++;
        }
        return count;
    }

    static int findBodyCount(Position heart, char[][] map) {
        int count = 0;
        for (int i = heart.i + 1; i < map.length; i++) {
            if (map[i][heart.j] == EMPTY) return count;
            count++;
        }
        return count;
    }

    static int findLeftLegCount(Position waist, char[][] map) {
        int count = 0;
        for (int i = waist.i + 1; i < map.length; i++) {
            if (map[i][waist.j - 1] == EMPTY) return count;
            count++;
        }
        return count;
    }

    static int findRightLegCount(Position waist, char[][] map) {
        int count = 0;
        for (int i = waist.i + 1; i < map.length; i++) {
            if (map[i][waist.j + 1] == EMPTY) return count;
            count++;
        }
        return count;
    }

    static boolean isHeart(int i, int j, char[][] map) {
        return map[i][j] == BODY &&
                map[i - 1][j] == BODY &&
                map[i + 1][j] == BODY &&
                map[i][j - 1] == BODY &&
                map[i][j + 1] == BODY;
    }

    static boolean isWaist(int i, int j, char[][] map) {
        return map[i][j] == BODY &&
                map[i + 1][j - 1] == BODY &&
                map[i + 1][j + 1] == BODY &&
                map[i + 1][j] == EMPTY;
    }
}
