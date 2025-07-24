package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> stack;
    int min;

    public MinStack() {
        stack= new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.add(val);
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.removeLast();
        if(min == stack.getLast()) {
            min = Integer.MAX_VALUE;
            for (int num : stack) {
                if (num < min) {
                    min = num;
                }
            }
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}
