package leetcode.hot100;

import leetcode.common.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode nextNode = curNode.next;
        curNode.next = null;
        while(nextNode.next != null) {
            ListNode temp = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = temp;
        }
        nextNode.next = curNode;
        return nextNode;
    }
}
