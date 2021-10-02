package com.javaps.P복서정렬하기;

import java.util.ArrayList;

class People {
    double per;
    int cnt, weight, id;
    People(double per, int cnt, int weight, int id) {
        this.per = per;
        this.cnt = cnt;
        this.weight = weight;
        this.id = id;
    }

    public void print() {
        System.out.println(this.per + ":" + this.cnt + ":" + this.weight + ":" + this.id);
    }
}

class Solution {
    static ArrayList<People> peoples = new ArrayList<People>();

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            int cnt = 0;
            int perCnt = 0;
            double sum = 0;
            for (int j = 0; j < head2head[i].length(); j++) {
                if (j == i) continue;
                if (head2head[i].charAt(j) != 'N') perCnt++;
                if (head2head[i].charAt(j) == 'W') {
                    sum++;
                    if (weight < weights[j]) {
                        cnt++;
                    }
                }
            }
            double per = perCnt == 0 ? 0 : (double) (sum / perCnt) * 100;
            People people = new People(per, cnt, weight, i + 1);
            peoples.add(people);
        }
        peoples.sort((o1, o2) -> {
            if (o2.per == o1.per) {
                if (o2.cnt == o1.cnt) {
                    if (o2.weight == o1.weight) {
                        return o1.id - o2.id;
                    } else {
                        return o2.weight - o1.weight;
                    }
                } else {
                    return o2.cnt - o1.cnt;
                }
            } else {
                if (o2.per > o1.per) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
        for (int i = 0; i < weights.length; i++) {
            peoples.get(i).print();
            answer[i] = peoples.get(i).id;
        }
        return answer;
    }

}