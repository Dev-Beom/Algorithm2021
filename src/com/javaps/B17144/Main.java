package com.javaps.B17144;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int i, j;

    Position(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class FineDust extends Position {
    int value;

    FineDust(int i, int j, int value) {
        super(i, j);
        this.value = value;
    }
}

class AirPurifier {
    Position top, bottom;

    AirPurifier(Position top, Position bottom) {
        this.top = top;
        this.bottom = bottom;
    }
}

public class Main {
    static Queue<FineDust> fineDusts = new LinkedList<>();
    static ArrayList<AirPurifier> airPurifiers = new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        initMap(R, C, br);

        while (T-- > 0) {
            spreadFineDust();
            airPurifierWorking();
            refreshFineDusts();
        }
        System.out.println(getSumOfFineDustsValue());
    }

    private static void refreshFineDusts() {
        fineDusts.clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isFineDust(i, j)) {
                    fineDusts.offer(new FineDust(i, j, map[i][j]));
                }
            }
        }
    }

    private static int getSumOfFineDustsValue() {
        int count = 0;
        for (FineDust fineDust : fineDusts){
            count+= fineDust.value;
        }
        return count;
    }


    private static void initMap(int R, int C, BufferedReader br) throws IOException {
        ArrayList<Position> airPurifierPositions = new ArrayList<>();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (isFineDust(i, j)) {
                    fineDusts.offer(new FineDust(i, j, map[i][j]));
                } else if (isAirPurifier(i, j)) {
                    airPurifierPositions.add(new Position(i, j));
                }
            }
        }
        for (int i = 0; i < airPurifierPositions.size(); i += 2) {
            airPurifiers.add(new AirPurifier(airPurifierPositions.get(i), airPurifierPositions.get(i + 1)));
        }
    }

    private static boolean isFineDust(int i, int j) {
        return map[i][j] > 0;
    }

    private static boolean isAirPurifier(int i, int j) {
        return map[i][j] == -1;
    }

    private static boolean canSpread(int i, int j) {
        return i >= 0 && i < map.length && j >= 0 && j < map[0].length && !isAirPurifier(i, j);
    }

    private static void spreadFineDust() {
        Queue<FineDust> newFineDusts = new LinkedList<>();
        while (!fineDusts.isEmpty()) {
            FineDust fineDust = fineDusts.poll();
            int[] iArr = {-1, 0, 1, 0};
            int[] jArr = {0, -1, 0, 1};

            int spreadCount = 0;
            for (int i = 0; i < 4; i++) {
                int di = iArr[i] + fineDust.i;
                int dj = jArr[i] + fineDust.j;
                if (canSpread(di, dj)) {
                    spreadCount++;
                    int spreadValue = getSpreadValue(fineDust.i, fineDust.j);
                    newFineDusts.offer(new FineDust(di, dj, spreadValue));
                }
            }
            int remainingValue = getRemainingValue(fineDust.i, fineDust.j, spreadCount);
            newFineDusts.offer(new FineDust(fineDust.i, fineDust.j, remainingValue));
            map[fineDust.i][fineDust.j] = 0;
        }
        for (FineDust newFineDust : newFineDusts) {
            map[newFineDust.i][newFineDust.j] = map[newFineDust.i][newFineDust.j] + newFineDust.value;
        }
    }

    private static int getSpreadValue(int i, int j) {
        return (int) Math.floor((double) map[i][j] / 5);
    }

    private static int getRemainingValue(int i, int j, int spreadCount) {
        return (map[i][j] - (getSpreadValue(i, j) * spreadCount));
    }

    private static void airPurifierWorking() {
        for (AirPurifier airPurifier : airPurifiers) {
            int tmp = 0;
            for (int j = 1; j < map[0].length; j++) {
                if (j == 1) {
                    tmp = map[airPurifier.top.i][j];
                    map[airPurifier.top.i][j] = 0;
                } else {
                    int newTmp = map[airPurifier.top.i][j];
                    map[airPurifier.top.i][j] = tmp;
                    tmp = newTmp;
                }
            }
            for (int i = airPurifier.top.i - 1; i >= 0; i--) {
                int newTmp = map[i][map[0].length - 1];
                map[i][map[0].length - 1] = tmp;
                tmp = newTmp;
            }
            for (int j = map[0].length - 2; j >= 0; j--) {
                int newTmp = map[0][j];
                map[0][j] = tmp;
                tmp = newTmp;
            }
            for (int i = 1; i < airPurifier.top.i; i++) {
                int newTmp = map[i][airPurifier.top.j];
                map[i][airPurifier.top.j] = tmp;
                tmp = newTmp;
            }

            for (int j = 1; j < map[0].length; j++) {
                if (j == 1) {
                    tmp = map[airPurifier.bottom.i][j];
                    map[airPurifier.bottom.i][j] = 0;
                } else {
                    int newTmp = map[airPurifier.bottom.i][j];
                    map[airPurifier.bottom.i][j] = tmp;
                    tmp = newTmp;
                }
            }
            for (int i = airPurifier.bottom.i + 1; i < map.length; i++) {
                int newTmp = map[i][map[0].length - 1];
                map[i][map[0].length - 1] = tmp;
                tmp = newTmp;
            }
            for (int j = map[0].length - 2; j >= 0; j--) {
                int newTmp = map[map.length - 1][j];
                map[map.length - 1][j] = tmp;
                tmp = newTmp;
            }
            for (int i = map.length - 2; i > airPurifier.bottom.i; i--) {
                int newTmp = map[i][airPurifier.bottom.j];
                map[i][airPurifier.bottom.j] = tmp;
                tmp = newTmp;
            }
        }
    }
}
