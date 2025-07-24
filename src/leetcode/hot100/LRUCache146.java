package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache146 {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode next;
        DLinkedNode pre;

        public DLinkedNode() {}

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }

    Map<Integer, DLinkedNode> data;
    int capacity;
    List<Integer> dataOrder;
    DLinkedNode head;
    DLinkedNode tail;
    int size;

    public LRUCache146(int capacity) {
        data = new HashMap<>();
        this.capacity = capacity;
        dataOrder = new ArrayList<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        size = 0;
    }

    public int get(int key) {
        if(data.get(key) == null) {
            return -1;
        }

        DLinkedNode node = data.get(key);

        moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = data.get(key);
        if(node == null) {
            data.put(key, node);
            addToHead(new DLinkedNode(key, value));
            size++;
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                data.remove(tail.key);
                size--;
            }
        } else {

        }
    }

    void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        if(head.next != null) {
            head.next.pre = node;
        }
        head.next = node;
        if(tail.pre == null) {
            tail.pre = node;
        }
    }
    DLinkedNode removeTail() {
        if(tail.pre == null) {
            return null;
        }
        DLinkedNode node = tail.pre;
        tail.pre = node.pre;
        if(node.pre != null) {
            node.pre.next = tail;
        }
        return node;
    }

    void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache146 cache = new LRUCache146(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(1));
        cache.put(4,4);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
