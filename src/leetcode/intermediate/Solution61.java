package leetcode.intermediate;

import leetcode.common.ListNode;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        if(k == 0) {
            return head;
        }
        int size = 1;
        ListNode lastNode;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }
        if(k%size == 0) {
            return head;
        }
        lastNode = currentNode;
        int a = size - k%size;
        ListNode newLastNode = head;
        for(int i = 0; i < a-1; i++) {
            newLastNode = newLastNode.next;
        }
        ListNode newHead = newLastNode.next;
        newLastNode.next = null;
        lastNode.next = head;

        return newHead;
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

        Solution61 solution61 = new Solution61();
        ListNode newHead = solution61.rotateRight(head,2);

        System.out.println(newHead.val);
        while(newHead.next != null) {
            newHead = newHead.next;
            System.out.println(newHead.val);
        }

    }
}
