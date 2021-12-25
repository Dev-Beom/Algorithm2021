package com.javaps.B8972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean isEquals(Node node) {
            return this.i == node.i && this.j == node.j;
        }
    }

    static String commands;
    static int R, C;
    static char[][] map;
    static Node myArduino;
    static LinkedList<Node> crazyArduinos = new LinkedList<>();
    static int moveCount = 0;
    final static char MY_ARDUINO_BLOCK = 'I';
    final static char CRAZY_ARDUINO_BLOCK = 'R';
    final static char EMPTY_BLOCK = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char currValue = line.charAt(j);
                map[i][j] = currValue;
                if (currValue == MY_ARDUINO_BLOCK) myArduino = new Node(i, j);
                else if (currValue == CRAZY_ARDUINO_BLOCK) crazyArduinos.add(new Node(i, j));
            }
        }
        commands = br.readLine();
        for (int i = 0; i < commands.length(); i++) {
            int command = commands.charAt(i) - '0';
            if (!canMoveAndMove(command)) {
                System.out.println("kraj " + (moveCount + 1));
                return;
            }
            if (canLoseAndCrazyArduinoMove()) {
                System.out.println("kraj " + (moveCount + 1));
                return;
            }
            mapReplace();
            moveCount++;
        }
        displayMap();
    }

    private static boolean canMoveAndMove(int command) {
        int[] iArr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] jArr = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
        int di = myArduino.i + iArr[command];
        int dj = myArduino.j + jArr[command];
        if (map[di][dj] == CRAZY_ARDUINO_BLOCK) return false;
        map[myArduino.i][myArduino.j] = EMPTY_BLOCK;
        map[di][dj] = MY_ARDUINO_BLOCK;
        myArduino = new Node(di, dj);
        return true;
    }

    private static boolean canLoseAndCrazyArduinoMove() {
        int[] iArr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] jArr = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[][] tmp = new int[R][C];
        LinkedList<Node> newCrazyArduinos = new LinkedList<>();
        for (Node crazyArduino : crazyArduinos) {
            int minIdx = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= 9; i++) {
                int rowDistanceDiff = Math.abs(myArduino.i - (iArr[i] + crazyArduino.i));
                int colDistanceDiff = Math.abs(myArduino.j - (jArr[i] + crazyArduino.j));
                int distance = rowDistanceDiff + colDistanceDiff;
                if (distance < minDistance) {
                    minDistance = distance;
                    minIdx = i;
                }
            }
            int nextCrazyArduinoI = crazyArduino.i + iArr[minIdx];
            int nextCrazyArduinoJ = crazyArduino.j + jArr[minIdx];
            if (map[nextCrazyArduinoI][nextCrazyArduinoJ] == MY_ARDUINO_BLOCK) {
                return true;
            }
            tmp[nextCrazyArduinoI][nextCrazyArduinoJ]++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (tmp[i][j] == 1) {
                    newCrazyArduinos.add(new Node(i, j));
                }
            }
        }
        crazyArduinos = newCrazyArduinos;
        return false;
    }

    private static void mapReplace() {
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(map[i], EMPTY_BLOCK);
        }
        map[myArduino.i][myArduino.j] = MY_ARDUINO_BLOCK;
        for (Node crazyArduino : crazyArduinos) {
            map[crazyArduino.i][crazyArduino.j] = CRAZY_ARDUINO_BLOCK;
        }
    }

    private static void displayMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
