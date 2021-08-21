package com.javaps.P최솟값만들기;

import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }
        return answer;
    }
}