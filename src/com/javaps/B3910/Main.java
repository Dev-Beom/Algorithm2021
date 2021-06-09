package com.javaps.B3910;

import java.util.*;
import java.io.*;

class Command {
    int time;
    char arrow;

    Command(int time, char arrow) {
        this.time = time;
        this.arrow = arrow;
    }
}

class Snake {
    int x;
    int y;

    Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // INPUT
    static int N;   // 보드의 크기 N
    static int K;   // 사과의 개수 K
    static Queue<Command> commands = new LinkedList<>();   // 명령어

    static int[][] map;

    static Deque<Snake> snake = new LinkedList<>(); // 뱀의 몸

    static int arrowIndex;

    static int second;

    public static void main(String[] args) throws IOException {
        // INIT VARIABLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        // INPUT
        N = Integer.parseInt(br.readLine()); // 보드의 크기 N
        K = Integer.parseInt(br.readLine()); // 사과의 개수 K

        map = new int[N][N];
        // MAP 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 2;  // 사과
        }
        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 정보
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            commands.add(new Command(X, C));
        }

        second = 0;

        snake.add(new Snake(0, 0));
        map[0][0] = 1;
        arrowIndex = 0;
        while (true) {
            second++;
            Command command = commands.peek();
            Snake head = snake.peekFirst();
            int hx = head.x;
            int hy = head.y;
            if (!commands.isEmpty() && command.time == second - 1) {
                command = commands.poll();
                if (command.arrow == 'D') {
                    arrowIndex =
                            arrowIndex == 0 ? 3 :
                                    arrowIndex == 1 ? 0 :
                                            arrowIndex == 2 ? 1 :
                                                    arrowIndex == 3 ? 2 : -1;
                } else if (command.arrow == 'L') {
                    arrowIndex =
                            arrowIndex == 0 ? 1 :
                                    arrowIndex == 1 ? 2 :
                                            arrowIndex == 2 ? 3 :
                                                    arrowIndex == 3 ? 0 : -1;
                }
            }
            switch (arrowIndex) {
                case 0: // 오른쪽 방향
                    hx = hx;
                    hy = hy + 1;
                    break;
                case 1: // 위쪽 방향
                    hx = hx - 1;
                    hy = hy;
                    break;
                case 2: // 왼쪽 방향
                    hx = hx;
                    hy = hy - 1;
                    break;
                case 3: // 아래쪽 방향
                    hx = hx + 1;
                    hy = hy;
                    break;
            }
            if (hx < 0 || hx >= N || hy < 0 || hy >= N || map[hx][hy] == 1) {   // 몸통 박치기, 맵 오버
                break;
            }
            if (map[hx][hy] == 2) {
                map[hx][hy] = 1;
                snake.addFirst(new Snake(hx, hy));
            } else if (map[hx][hy] == 0) {
                map[hx][hy] = 1;
                Snake tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
                snake.addFirst(new Snake(hx, hy));
            }
        }
        System.out.println(second);
    }
}
