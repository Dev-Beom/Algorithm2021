package com.javaps.P타겟넘버;


/*
DFS 문제는 Stack 또는 재귀를 통해 풀이가 가능함.
결국 배열에 있ㄴㄴ 요소가 하나의 노드라고 비유한다면, 배열의 인덱스는 깊이라고 비유할 수 있음.
결국은 각 깊이에 대해 모두 탐색하게 되고, 모든 경우의 수를 모두 탐색하게 된다.
 */

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int index, int num) {
        if(index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return dfs(numbers, target, index + 1, num + numbers[index])
                    + dfs(numbers, target, index + 1, num - numbers[index]);
        }
    }
}
