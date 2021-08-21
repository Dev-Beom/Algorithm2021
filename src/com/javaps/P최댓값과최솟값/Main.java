package com.javaps.P최댓값과최솟값;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();
        Arrays.stream(strs).forEach(e -> integers.add(Integer.parseInt(e)));
        Collections.sort(integers);
        answer += integers.get(0).toString() + " " + integers.get(integers.size() - 1);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution("1 2 3 4"));
        System.out.println(solution.solution("-1 -2 -3 -4"));
        System.out.println(solution.solution("-1 -1"));
    }
}
