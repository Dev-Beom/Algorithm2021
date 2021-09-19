package com.javaps.P방문길이;

import java.util.HashMap;

class Solution {

    static HashMap<String, Integer> history = new HashMap<>();

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    static int x = 5;
    static int y = 5;
    public int solution(String dirs) {
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int idx = 0;
            if (ch == 'U') idx = 3;
            else if (ch == 'D') idx = 1;
            else if (ch == 'R') idx = 0;
            else if (ch == 'L') idx = 2;
            int nextX = x + dx[idx];
            int nextY = y + dy[idx];
            if (!isRange(nextX, nextY)) continue;
            String token1 = getToken1(x, y, nextX, nextY);
            String token2 = getToken2(x, y, nextX, nextY);
            if (!history.containsKey(token1) && !history.containsKey(token2)) {
                history.put(token1, 0);
            }
            x = nextX;
            y = nextY;
        }
        return history.size();
    }

    public boolean isRange(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    public String getToken1(int currX, int currY, int nextX, int nextY) {
        StringBuilder sb = new StringBuilder();
        sb.append(currX).append(currY).append(":").append(nextX).append(nextY);
        return sb.toString();
    }

    public String getToken2(int currX, int currY, int nextX, int nextY) {
        StringBuilder sb = new StringBuilder();
        sb.append(nextX).append(nextY).append(":").append(currX).append(currY);
        return sb.toString();
    }
}