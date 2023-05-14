package com.javaps.LAdd_Two_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        boolean isUp = false;
        while (l1 != null || l2 != null || isUp) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (isUp ? 1 : 0);
            isUp = sum >= 10;
            list.add(sum % 10);
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        return listToListNode(list);
    }

    public ListNode listToListNode(List<Integer> list) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head.next;
    }
}
class Main {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        Solution solution = new Solution();
        solution.addTwoNumbers(listNode1, listNode2);
    }
}