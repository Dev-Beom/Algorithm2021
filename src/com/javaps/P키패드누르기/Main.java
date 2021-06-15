package com.javaps.P키패드누르기;

class Location {
    int x, y;
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static int[][] keyPad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Location left = new Location(3, 0);
        Location right = new Location(3, 2);
        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            if (key == 1 || key == 4 || key == 7) {
                sb.append('L');
                left = valueToLocation(key);
            } else if (key == 3 || key == 6 || key == 9) {
                sb.append('R');
                right = valueToLocation(key);
            } else {
                Location mid = valueToLocation(key);
                int leftDist = Math.abs(mid.x - left.x) + Math.abs(mid.y - left.y);
                int rightDist =  Math.abs(mid.x - right.x) + Math.abs(mid.y - right.y);
                if (leftDist > rightDist) {
                    sb.append('R');
                    right = valueToLocation(key);
                } else if (leftDist < rightDist) {
                    sb.append('L');
                    left = valueToLocation(key);
                } else {
                    if (hand.equals("right")) {
                        sb.append('R');
                        right = mid;
                    } else {
                        sb.append('L');
                        left = mid;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static Location valueToLocation(int value) {
        for (int x = 0; x < keyPad.length; x++) {
            for (int y = 0; y < keyPad[0].length; y++) {
                if (keyPad[x][y] == value) {
                    return new Location(x, y);
                }
            }
        }
        return new Location(0, 0);
    }
}