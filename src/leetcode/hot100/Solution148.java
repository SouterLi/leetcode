package leetcode.hot100;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution148 {
    public ListNode sortList2(ListNode head) {
        ListNode quickNode = head.next;
        ListNode slowNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }
        ListNode temp = slowNode.next;
        slowNode.next = null;

        // 经过递归，head为头节点的一半排好序了，返回它的头节点leftHead
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(temp);

        ListNode resultNode = new ListNode(0);
        ListNode resultHead = resultNode;

        while ((leftHead != null && rightHead != null)) {
            if(leftHead.val < rightHead.val) {
                resultNode.next = leftHead;
                leftHead = leftHead.next;
            } else {
                resultNode.next = rightHead;
                rightHead = rightHead.next;
            }
            resultNode = resultNode.next;
        }
        resultNode.next = leftHead == null?rightHead:leftHead;
        return resultHead.next;
    }



    public ListNode sortList(ListNode head) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while(node !=null) {
            list.add(node);
            node = node.next;
            list.getLast().next = null;
        }

        return mergeList(list);
    }

    public ListNode mergeList(List<ListNode> list) {
        while(list.size() > 1) {
            List<ListNode> newList = new ArrayList<>();
            for(int i = 0; i< list.size()/2; i++) {
                ListNode head = merge(list.get(i), list.get(list.size()-i-1));
                newList.add(head);
            }
            list = newList;
        }

        return list.get(0);
    }

    public ListNode merge(ListNode nodeA, ListNode nodeB) {
        ListNode node = new ListNode();
        ListNode res = node;
        while(nodeA != null && nodeB != null) {
            if(nodeA.val < nodeB.val) {
                node.next = nodeA;
                nodeA = nodeA.next;
            } else {
                node.next = nodeB;
                nodeB = nodeB.next;
            }
            node = node.next;
        }
        if(nodeA != null) {
            node.next = nodeA;
        } else {
            node.next = nodeB;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(1);
        ListNode fourthNode = new ListNode(3);
        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        Solution148 solution148 = new Solution148();
        ListNode resultHead = solution148.sortList(head);

        while (resultHead != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }
}
