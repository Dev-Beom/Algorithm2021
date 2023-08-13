package com.javaps.B17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int MAX = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int myPosition = Integer.parseInt(st.nextToken());
        int targetPosition = Integer.parseInt(st.nextToken());

        System.out.println((myPosition == targetPosition) ? 0 : solution(myPosition, targetPosition));
    }

    private static int solution(int my, int target) {
        int[][] visit = new int[2][MAX + 1];
        for (int[] row : visit) {
            Arrays.fill(row, -1);
        }
        visit[0][my] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(my);

        int time = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            time++;
            int mod = time % 2;

            for (int i = 0; i < length; i++) {
                int currentMyPosition = queue.poll();
                int[] nextPositions = {currentMyPosition - 1, currentMyPosition + 1, currentMyPosition * 2};

                for (int nextPosition : nextPositions) {
                    if (nextPosition >= 0 && nextPosition <= MAX && visit[mod][nextPosition] == -1) {
                        queue.offer(nextPosition);
                        visit[mod][nextPosition] = time;
                    }
                }
            }

            int updatedTarget = getTarget(time, target);
            if (updatedTarget > MAX) {
                break;
            }
            if (visit[mod][updatedTarget] != -1) {
                return time;
            }
        }
        return -1;
    }

    private static int getTarget(int my, int target) {
        return target + (my * (my + 1) / 2);
    }
}
