package leetcode.intermediate;

import leetcode.common.ListNode;

public class Solution24 {

// 1,2,3,4,5,6
// 2,1,3,4,5,6
// 2,1,4,3,5,6
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode resultNode = node2;
        ListNode node3 = node2.next;
        node2.next = node1;
        node1.next = node3;
        while (node1.next != null && node1.next.next != null) {
            node2 = node1.next;
            node3 = node2.next;
            ListNode node4 = node3.next;
            node3.next = node2;
            node2.next = node4;
            node1.next = node3;
            node1 = node2;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
//        ListNode fourthNode = new ListNode(4);
//        ListNode fifthNode = new ListNode(5);
//        ListNode sixthNode = new ListNode(6);
        head.next = secondNode;
        secondNode.next = thirdNode;
//        thirdNode.next = fourthNode;
//        fourthNode.next = fifthNode;
//        fifthNode.next = sixthNode;

        Solution24 solution24 = new Solution24();
        ListNode newHead = solution24.swapPairs(head);
        System.out.println(newHead.val);
        while(newHead.next != null) {
            newHead = newHead.next;
            System.out.println(newHead.val);
        }
    }
}

