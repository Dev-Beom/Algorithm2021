package com.javaps.P피로도;

class Solution {
    public static boolean[] visited;
    public static int MAX = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(k, dungeons, 0);
        return MAX;
    }

    public static void DFS(int tired, int[][] dungeons, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            int currNeedTired = dungeons[i][0];
            int currTired = dungeons[i][1];
            if (!visited[i] && currNeedTired <= tired) {
                visited[i] = true;
                DFS(tired - currTired, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
        MAX = Math.max(MAX, cnt);
    }
}
