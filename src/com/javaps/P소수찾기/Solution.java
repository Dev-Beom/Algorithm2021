package com.javaps.P소수찾기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] sosu = new boolean[n + 1];

        for (int i = 2; i <= n; i++) sosu[i] = true;
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) if (sosu[i]) for (int j = i; i * j <= n; j++) sosu[i * j] = false;
        for (int i = 2; i <= n; i++) if (sosu[i]) answer++;
        return answer;
    }
}
