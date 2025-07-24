package leetcode.intermediate;

import leetcode.common.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = head;
        ListNode newHead = new ListNode();
        ListNode lNode = new ListNode();
        ListNode rNode = new ListNode();
        int size = 1;
        while(head.next != null && size <= right) {
            if(size < left-1) {
                leftNode = leftNode.next;
            }
            if(size == left-1) {
                newHead = leftNode.next;
                lNode = newHead;
                rNode = lNode.next;
            }
            if(size > left-1 && size < right) {
                ListNode node = rNode.next;
                rNode.next = lNode;
                lNode = rNode;
                rNode = node;
            }
            size++;
        }
        newHead.next = rNode;
        leftNode.next = lNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        Solution92 solution92 = new Solution92();
        ListNode newhead = solution92.reverseBetween(head,2,4);
        System.out.println(newhead.val);
        while (newhead.next != null) {
            newhead = newhead.next;
            System.out.println(newhead.val);
        }
    }
}
