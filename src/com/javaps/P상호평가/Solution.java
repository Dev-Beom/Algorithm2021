package com.javaps.P상호평가;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        double[] average = new double[scores.length];
        // get Average
        for (int i = 0; i < scores.length; i++) {
            int[] currScore = new int[scores.length];
            int sum = 0;
            int cnt = 0;
            for (int j = 0; j < scores[0].length; j++) {
                currScore[j] = scores[j][i];
            }
            if (isOnlyMax(i, currScore) || isOnlyMin(i, currScore)) {
                average[i] = getAverage(currScore, true, i);
            } else {
                average[i] = getAverage(currScore, false, i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (double e : average) {
            sb.append(getGrades(e));
        }
        return sb.toString();
    }

    static private boolean isOnlyMax(int index, int[] arr) {
        int base = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if (index == i) continue;
            if (base == arr[i]) return false;
            if (base < arr[i]) return false;
        }
        return true;
    }

    static private boolean isOnlyMin(int index, int[] arr) {
        int base = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if (index == i) continue;
            if (base == arr[i]) return false;
            if (base > arr[i]) return false;
        }
        return true;
    }

    static private double getAverage(int[] arr, boolean option, int index) {
        int sum = 0;
        if (option) {
            arr[index] = 0;
            for (int e : arr) {
                sum += e;
            }
            return (double) sum / (arr.length - 1);
        } else {
            for (int e : arr) {
                sum += e;
            }
            return (double) sum / arr.length;
        }
    }

    static private char getGrades(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 50) return 'D';
        return 'F';
    }
}