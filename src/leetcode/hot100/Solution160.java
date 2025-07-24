package leetcode.hot100;

import leetcode.common.ListNode;
import leetcode.intermediate.Solution92;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> listA = new ArrayList<>();
        listA.add(headA.val);
        ListNode tempA = headA;
        while (tempA.next != null) {
            tempA = tempA.next;
            listA.addFirst(tempA.val);
        }

        List<Integer> listB = new ArrayList<>();
        listB.add(headB.val);
        ListNode tempB = headB;
        while (tempB.next != null) {
            tempB = tempB.next;
            listB.addFirst(tempB.val);
        }

        int sameSize = 0;
        for(int i = 0; i< Math.min(listA.size(),listB.size()); i++) {
            if(listA.get(i).equals(listB.get(i))) {
                sameSize = i+1;
            }
        }

        int positionA = listA.size() - sameSize;
        tempA = headA;
        while(positionA > 0) {
            tempA = tempA.next;
            positionA--;
        }

        int positionB = listB.size() - sameSize;
        tempB = headB;
        while(positionB > 0) {
            tempB = tempB.next;
            positionB--;
        }

        while (tempB != tempA) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode tempA = headA;
        while (tempA != null) {
            map.put(tempA, 1);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            if(map.containsKey(tempB)) {
                return tempB;
            } else {
                tempB = tempB.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA!=tempB) {
            if(tempA == null) {
                tempA = headB;
            }
            if(tempB == null) {
                tempB = headA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(8);
        ListNode fourthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        ListNode headB = new ListNode(5);
        ListNode secondNodeB = new ListNode(6);
        ListNode thirdNodeB = new ListNode(1);
        headB.next = secondNodeB;
        secondNodeB.next = thirdNodeB;
        thirdNodeB.next = thirdNode;

        Solution160 solution160 = new Solution160();
        ListNode intersectionNode = solution160.getIntersectionNode3(head, headB);
        System.out.println(intersectionNode.val);
    }
}