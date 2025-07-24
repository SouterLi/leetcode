package leetcode.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);
        int result = 1;
        for(int i = 1; i < chars.length; i++) {
            while (list.contains(s.charAt(i))) {
                list.removeFirst();
            }
            list.add(chars[i]);
            result = Math.max(result, list.size());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "pwwkew";
        int result = solution3.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
