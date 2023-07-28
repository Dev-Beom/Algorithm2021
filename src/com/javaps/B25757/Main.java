package com.javaps.B25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


enum Game {
    YUT_NORI(2), FINE_THE_SAME_CARD(3), ONE_CARD(4);
    private final int peopleCount;

    Game(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    static Game of(String symbol) {
        switch (symbol) {
            case "Y":
                return YUT_NORI;
            case "F":
                return FINE_THE_SAME_CARD;
            case "O":
                return ONE_CARD;
            default:
                return null;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int requestCount = Integer.parseInt(st.nextToken());
        Game game = Game.of(st.nextToken());
        HashSet<String> uniqueUsers = new HashSet<>();
        while (requestCount-- > 0) {
            uniqueUsers.add(br.readLine());
        }
        System.out.println(getGameCount(game, uniqueUsers));
    }

    public static int getGameCount(Game game, HashSet<String> uniqueUsers) {
        return uniqueUsers.size() / (game.getPeopleCount() - 1);
    }
}
