package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> stack = new ArrayList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]) {
                int index = stack.getLast();
                result[index] = i - index;
                stack.removeLast();
            }
            stack.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution739 solution = new Solution739();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
