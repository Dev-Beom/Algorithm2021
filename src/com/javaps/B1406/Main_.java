package com.javaps.B1406;

import java.io.IOException;
import java.util.*;

enum Move {
    RIGHT, LEFT
}

public class Main_ {

    //  linked list
    private static final LinkedList<Character> data = new LinkedList<>();
    private static int cursor;
    private static int size;
    private static StringBuilder sb = new StringBuilder();

    public static void displayData() {
        data.forEach(x -> sb.append(x));
        System.out.println(sb);
    }

    public static void cursorMove(Move move) {
        if (move.equals(Move.RIGHT)) {
            if (size > cursor) {
                cursor++;
            }
        } else if (move.equals(Move.LEFT)) {
            if (0 < cursor) {
                cursor--;
            }
        }
    }

    public static void insertChar(Character character) {
        data.add(cursor, character);
        size++;
        cursor++;
    }

    public static void deleteChar() {
        if (0 < cursor) {
            data.remove(cursor - 1);
            size--;
            cursor--;
        }
    }

    public static void commandLineReader(String line) {
        line.chars().forEach(x -> {
            if (x == (int) 'L') {
                cursorMove(Move.LEFT);
            } else if (x == (int) 'D') {
                cursorMove(Move.RIGHT);
            } else if (x == (int) 'B') {
                deleteChar();
            } else if (x == (int) 'P') {
            } else {
                insertChar((char) x);
            }
        });
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int M = 0;
        String command;

        // Init First line
        String str = scanner.nextLine();
        str.chars().forEach(x -> {
            cursor++;
            size++;
            data.add((char) x);
        });

        M = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < M; i++) {
            command = scanner.nextLine().replaceAll(" ", "");
            commandLineReader(command);
        }
        displayData();
    }
}
