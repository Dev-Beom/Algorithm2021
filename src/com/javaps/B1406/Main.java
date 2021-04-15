package com.javaps.B1406;

import java.io.IOException;
import java.util.*;

enum Move {
    RIGHT, LEFT
}

public class Main {

    //  linked list
    private static final LinkedList<Character> data = new LinkedList<>();
    private static int cursor;

    public static void displayData() {
        data.forEach(System.out::print);
        System.out.println();
    }

    public static void cursorMove(Move move) {
        if (move.equals(Move.RIGHT)) {
            if (data.size() > cursor) {
                System.out.println("right");
                cursor++;
            }
        } else if (move.equals(Move.LEFT)) {
            if (0 < cursor) {
                System.out.println("left");
                cursor--;
            }
        }
        System.out.println("cursor now = " + cursor + ", cursor data = " + data.get(cursor));

    }

    public static void insertChar(Character character) {
        System.out.println("insertChar() " + character);
    }

    public static void deleteChar() {
        if (0 < cursor) {
            System.out.println("deleteChar()");
            data.remove(cursor - 1);
            cursor--;
        }
    }

    public static void commandLineReader(String line) {
        line.chars().forEach(x -> {
            boolean isInsert = false;
            if (x == (int) 'L') {
                cursorMove(Move.LEFT);
            } else if (x == (int) 'R') {
                cursorMove(Move.RIGHT);
            } else if (x == (int) 'B') {
                deleteChar();
            } else if (x == (int) 'P') {
                isInsert = true;
            } else if (isInsert) {
                insertChar((char) x);
            }
        });
        displayData();
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int M = 0;
        String command;

        // Init First line
        String str = scanner.nextLine();
        str.chars().forEach(x -> {
            cursor++;
            data.add((char) x);
        });
        data.forEach(System.out::println);

        try {
            M = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < M; i++) {
            command = scanner.nextLine();
            commandLineReader(command);
        }
    }
}
