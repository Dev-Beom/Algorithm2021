package com.javaps.P체육복;

import java.util.Arrays;

class Solution {

    static int[] student;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        student = new int[n];

        Arrays.fill(student, 1);
        for (int i = 0; i < lost.length; i++) {
            student[lost[i] - 1] = 0;
        }
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }
        rentCloth();
        for (int i = 0; i < student.length; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }

    static void rentCloth() {
        for (int i = 0; i < student.length; i++) {
            if (isRange(i) && student[i] == 2) {
                if (student[i - 1] == 0) {
                    student[i - 1]++;
                    student[i]--;
                } else if (student[i + 1] == 0) {
                    student[i+1]++;
                    student[i]--;
                }
            } else if (i == 0 && student[i] == 2 && student[i + 1] == 0) {
                student[i + 1]++;
                student[i]--;
            } else if (i == student.length - 1 &&
                    student[i] == 2 && student[i - 1] == 0) {
                student[i - 1]++;
                student[i]--;
            }
        }
    }

    static boolean isRange(int value) {
        if (value <= 0 || value >= student.length - 1) return false;
        return true;
    }



}
