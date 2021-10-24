package com.javaps.CD.NHNOR1;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.HashMap;

public class main {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int head = 1;

    private static void solution(int numOfOperation, Operation[] operations) {
        map.put(1, 1);

        for (int TC = 0; TC < numOfOperation; TC++) {
            Operation curr = operations[TC];

            if (curr.type == OperationType.branch) {
                for (int i = 1; i < 100000; i++) {
                    head = i;
                    if (!map.containsKey(head)) {
                        map.put(head, 1);
                        break;
                    }
                }
            } else {
                head = curr.value;
                map.remove(head)
            }
        }

        for (Integer i : map.keySet()) System.out.print(i + " ");
    }

}
