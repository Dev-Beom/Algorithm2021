package com.javaps.B2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Robot {
    int id, x, y, direction;
    // S, E, N, W
    int[] xArr = {0, 1, 0, -1};
    int[] yArr = {-1, 0, 1, 0};

    Robot(int id, int x, int y, int direction) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void go() {
        x = xArr[direction] + x;
        y = yArr[direction] + y;
    }

    public void rotateLeft() {
        direction = (direction + 1) % 4;
    }

    public void rotateRight() {
        direction = (direction - 1) < 0 ? 3 : (direction - 1);
    }
}

public class Main {
    static HashMap<Integer, Robot> robotTable = new HashMap<>();
    static int A, B, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            int id = i + 1;
            robotTable.put(id, new Robot(id, x, y, getDirection(d)));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            String rotate = st.nextToken();
            int loopCnt = Integer.parseInt(st.nextToken());
            if (!command(id, rotate, loopCnt)) return;
        }
        System.out.println("OK");
    }

    private static boolean command(int id, String rotate, int loopCnt) {
        Robot robot = robotTable.get(id);
        for (int i = 0; i < loopCnt; i++) {
            switch (rotate) {
                case "L":
                    robot.rotateLeft();
                    break;
                case "R":
                    robot.rotateRight();
                    break;
                case "F":
                    robot.go();
                    if (!isRange(robot)) {
                        System.out.println("Robot " + id + " crashes into the wall");
                        return false;
                    }
                    int crashRobotIdx = getCrashRobotIdx(robot);
                    if (crashRobotIdx != -1) {
                        System.out.println("Robot " + id + " crashes into robot " + crashRobotIdx);
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    private static boolean isRange(Robot robot) {
        return robot.x >= 0 && robot.x < A && robot.y >= 0 && robot.y < B;
    }

    private static int getCrashRobotIdx(Robot robot) {
        for (int i = 1; i <= N; i++) {
            if (robot.id == robotTable.get(i).id) continue;
            if (robot.x == robotTable.get(i).x && robot.y == robotTable.get(i).y) {
                return robotTable.get(i).id;
            }
        }
        return -1;
    }

    public static int getDirection(String str) {
        switch (str) {
            case "S":
                return 0;
            case "E":
                return 1;
            case "N":
                return 2;
            case "W":
                return 3;
        }
        return -1;
    }
}
