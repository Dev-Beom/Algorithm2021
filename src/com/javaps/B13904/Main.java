package com.javaps.B13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int deadline, score;

        Node(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }
    }

    static int N;
    static ArrayList<Node> assignmentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            assignmentList.add(new Node(d, w));
            maxDay = Math.max(d, maxDay);
        }

        int answer = 0;
        for (int i = maxDay; i > 0; i--) {
            answer += getMaxScore(i);
        }
        System.out.println(answer);
    }

    private static int getMaxScore(int now) {
        int idx = 0;
        int result = 0;
        for (int i = 0; i < assignmentList.size(); i++) {
            int currDeadline = assignmentList.get(i).deadline;
            int currScore = assignmentList.get(i).score;
            if (currDeadline >= now && result < currScore) {
                idx = i;
                result = currScore;
            }
        }
        if (result == 0) return 0;
        assignmentList.remove(idx);
        return result;
    }
}
