package com.javaps.P모음사전;

class Solution {
    static char chr[] = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        int answer = 0;
        int range = 781;

        for(int i = 0; i < word.length(); i++){
            System.out.println(range);
            for(int j = 0; j < 5; j++){
                if(chr[j] == word.charAt(i)){
                    answer += 1 + j * range;
                }
            }
            range = (range - 1) / 5;
        }
        return answer;
    }
}