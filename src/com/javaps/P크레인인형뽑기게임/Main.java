package com.javaps.P크레인인형뽑기게임;

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int pick = board[j][moves[i] - 1];
                if (pick != 0) {
                    if (!basket.isEmpty() && pick == basket.peek()) {
                        board[j][moves[i] - 1] = 0;
                        answer += 2;
                        basket.pop();
                        break;
                    } else {
                        basket.push(pick);
                        board[j][moves[i] - 1] = 0;
                        break;
                    }

                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution.solution(board, moves));
    }
}
