package com.javaps.P로또의최고순위와최저순위;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int x = 0;
        int o = 0;
        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (win_nums[i] == lottos[j]) {
                    lottos[j] = 99;
                }
            }
        }

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                x++;
            } else if (lottos[i] == 99) {
                o++;
            }
        }
        answer[0] = calcRank(x + o);
        answer[1] = calcRank(o);
        return answer;
    }

    static int calcRank(int score) {
        switch(score) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;

        }
    }
}
