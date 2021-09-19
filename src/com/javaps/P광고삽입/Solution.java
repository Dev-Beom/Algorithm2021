package com.javaps.P광고삽입;

class Solution {
    static int playTime = 0, advTime = 0;
    static int[] timeLine;
    static long sum = 0, max = 0;
    static int startTime, endTime;

    public String solution(String play_time, String adv_time, String[] logs) {
        playTime = timeStrToSecond(play_time);
        advTime = timeStrToSecond(adv_time);
        timeLine = new int[playTime + 1];

        if (playTime == advTime) return "00:00:00";

        for (String log : logs) {
            String[] tmp = log.split("-");
            int startViewTime = timeStrToSecond(tmp[0]);
            int endViewTime = timeStrToSecond(tmp[1]);
            viewCounting(startViewTime, endViewTime);
        }

        startTime = 0;
        endTime = advTime;
        sum = getSumTime(startTime, endTime);
        max = sum;

        int maxTimeRange = 0;
        while (endTime <= playTime) {
            sum -= timeLine[startTime];
            sum += timeLine[endTime];
            if (sum > max) {
                max = sum;
                maxTimeRange = startTime + 1;
            }
            startTime++;
            endTime++;
        }
        return timeSecondToStr(maxTimeRange);
    }

    private void viewCounting(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) timeLine[i]++;
    }

    private long getSumTime(int startTime, int endTime) {
        long sum = 0;
        for (int i = startTime; i < endTime; i++) sum += timeLine[i];
        return sum;
    }

    private int timeStrToSecond(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]);
        int min = Integer.parseInt(tmp[1]);
        int sec = Integer.parseInt(tmp[2]);
        return sec + (min * 60) + (hour * 3600);
    }

    private String timeSecondToStr(int time) {
        int hour = time / 3600;
        int min = (time % 3600) / 60;
        int sec = (time % 60);
        return (hour < 10 ? "0" + hour : hour) + ":" +
                (min < 10 ? "0" + min : min) + ":" +
                (sec < 10 ? "0" + sec : sec);
    }
}