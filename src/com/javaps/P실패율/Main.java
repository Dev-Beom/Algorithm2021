package com.javaps.P실패율;

import java.util.*;

class Stage{
    int stage;
    double fail;
    Stage(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }
}

class Solution {

    static ArrayList<Stage> stagesList = new ArrayList<>();

    public int[] solution(int N, int[] stages) {

        int noClearUser = 0;
        int user = stages.length;

        for (int n = 1; n <= N; n++) {

            for (int i = 0; i < stages.length; i++) {

                if (n == stages[i]) {
                    noClearUser++;
                }
            }
            stagesList.add(new Stage(n, (double)noClearUser/(double)user));
            user -= noClearUser;
            noClearUser = 0;
        }
        Collections.sort(stagesList, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                if (s1.fail < s2.fail) {
                    return 1;
                } else if (s1.fail > s2.fail) {
                    return -1;
                }
                return 0;
            }
        });
        int[] answer = new int[stagesList.size()];
        for (int i = 0; i < stagesList.size(); i++) {
            answer[i] = stagesList.get(i).stage;
        }
        return answer;
    }
}