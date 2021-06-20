package com.javaps.P카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow; // 전체 격자 개수

        for (int i = 1; i <= area; i++) {
            int row = i;             // 세로
            int col = area / row;     // 가로

            // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다.
            if (row > col)
                continue;

            // 꼭짓점 때문에 4개 제거
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }
}
