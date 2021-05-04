package com.javaps.B4179;

import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N = 0;
    static int M = 0;

    static char[][] maze;
    static boolean[][] isVisited;

    static int time = -1;

    static Queue<Node> man = new LinkedList<>();
    static Queue<Node> fire = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = 0;

        maze = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = tmp[j];

                if (maze[i][j] == 'J') {
                    // 지훈이 위치가 입력되면 길로 바꾼 후 man 큐에 지훈이의 위치를 넣는다.
                    maze[i][j] = '.';

                    // 방문 처리
                    isVisited[i][j] = true;
                    man.add(new Node(i, j));

                } else if (maze[i][j] == 'F') {
                    // 입력받은 값이 불이면 fire 큐에 불의 위치를 넣는다,

                    // 방문 처리
                    isVisited[i][j] = true;
                    fire.add(new Node(i, j));
                }
            }
        }

        loop:
        while (!man.isEmpty()) {
            // FIRE
            int fireOfSize = fire.size();

            for (int s = 0; s < fireOfSize; s++){
                Node cur = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!isRange(nx, ny) || maze[nx][ny] != '.')
                        continue;
                    maze[nx][ny] = 'F';
                    fire.add(new Node(nx, ny));
                }
            }

            // MAN
            int manOfSize = man.size();

            for (int s = 0; s < manOfSize; s++) {
                Node cur = man.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!isRange(nx, ny)) {
                        // 밖으로 나가면
                        // 시간을 저장하고
                        time = ++count;

                        // loop 라벨의 반복문을 빠져나간다.
                        break loop;
                    }

                    if (isVisited[nx][ny] || maze[nx][ny] != '.')
                        // 방문했거나, 지나갈 수 있는 공간이 아니면
                        // 포문 건너뛰기
                        continue;
                    isVisited[nx][ny] = true;
                    man.add(new Node(nx, ny));
                }
            }
            count++;
        }
        System.out.println(time == -1 ? "IMPOSSIBLE" : time);
    }


    public static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
}
