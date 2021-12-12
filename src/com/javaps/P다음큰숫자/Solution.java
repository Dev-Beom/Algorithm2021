package com.javaps.P다음큰숫자;

class Solution {
    public int solution(int n) {
        int nextValue = n;
        int originOneCnt = getOneCnt(Integer.toBinaryString(n));
        while (true) {
            nextValue++;
            String binStr = Integer.toBinaryString(nextValue);
            if (getOneCnt(binStr) == originOneCnt) {
                break;
            }
        }
        return nextValue;
    }

    private int getOneCnt(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt ++;
            }
        }
        return cnt;
    }
}
